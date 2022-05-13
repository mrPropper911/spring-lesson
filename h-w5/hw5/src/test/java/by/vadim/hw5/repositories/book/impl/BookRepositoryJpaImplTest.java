package by.vadim.hw5.repositories.book.impl;

import by.vadim.hw5.models.Author;
import by.vadim.hw5.models.Book;
import by.vadim.hw5.models.Comment;
import by.vadim.hw5.models.Genre;
import lombok.val;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Repository check for work with BOOKS ")
@DataJpaTest
@Import(BookRepositoryJpaImpl.class)
class BookRepositoryJpaImplTest {
    private static final String TITLE_BOOK = "Спасибо что живой";
    private static final int PRICE_BOOK = 1;
    private static final String AUTHOR_NAME = "Высоцкий В.Ф.";
    private static final String GENRE_NAME = "Стихи";
    private static final String COMMENT_TEXT = "Тест";

    private static final long FIRST_BOOK_ID = 1L;

    private static final int EXPECTED_NUMBER_OF_BOOKS = 2;
    private static final int EXPECTED_QUERIES_COUNT = 2;
    private static final String FIRST_BOOK_TITLE = "Дон Кихот";
    private static final String TESTING_TITLE = "Testing title";

    @Autowired
    private BookRepositoryJpaImpl repositoryJpa;

    @Autowired
    private TestEntityManager testEntityManager;

    @DisplayName("should correct save all information about book")
    @Test
    void shouldSaveAllBookInfo() {
        val title = TITLE_BOOK;
        val price = PRICE_BOOK;

        val author = new Author();
        author.setName(AUTHOR_NAME);

        val genre = new Genre();
        genre.setName(GENRE_NAME);

        val comment = new Comment(0, COMMENT_TEXT);
        val comments = Collections.singletonList(comment);

        val book = new Book(0, TITLE_BOOK, PRICE_BOOK, author, genre, comments);
        repositoryJpa.save(book);
        assertThat(book.getId()).isGreaterThan(0);

        val actualBook = testEntityManager.find(Book.class, book.getId());
        assertThat(actualBook).isNotNull()
                .matches(s -> !s.getTitle().equals(""))
                .matches(s -> s.getPrice() != 0)
                .matches(s -> s.getAuthor() != null)
                .matches(s -> s.getGenre() != null)
                .matches(s -> s.getComments() != null && s.getComments().size() > 0
                        && s.getComments().get(0).getId() > 0);
    }

    @DisplayName("should get information about book by her Id")
    @Test
    void shouldFindExpectedBookById() {
        val optionalActualBook = repositoryJpa.findById(FIRST_BOOK_ID);
        val expectedBook = testEntityManager.find(Book.class, FIRST_BOOK_ID);
        assertThat(optionalActualBook).isPresent().get()
                .usingRecursiveComparison().isEqualTo(expectedBook);
    }

    @DisplayName("should return list of Book with all information about him")
    @Test
    void shouldReturnCorrectBooksListWithAllInfo() {
        //get statistic about queries
        SessionFactory sessionFactory = testEntityManager.getEntityManager().getEntityManagerFactory()
                .unwrap(SessionFactory.class);
        sessionFactory.getStatistics().setStatisticsEnabled(true);

        val books = repositoryJpa.findAll();
        assertThat(books).isNotNull().hasSize(EXPECTED_NUMBER_OF_BOOKS)
                .allMatch(s -> !s.getTitle().equals(""))
                .allMatch(s -> s.getPrice() != 0)
                .allMatch(s -> s.getAuthor() != null)
                .allMatch(s -> s.getGenre() != null)
                .allMatch(s -> s.getComments() != null && s.getComments().size() > 0);

        assertThat(sessionFactory.getStatistics().getPrepareStatementCount()).isEqualTo(EXPECTED_QUERIES_COUNT);
    }

    @DisplayName("should return information about book for her title")
    @Test
    void shouldFindExpectedBookByTitle() {
        val firstBook = testEntityManager.find(Book.class, FIRST_BOOK_ID);
        List<Book> books = repositoryJpa.findByTitle(FIRST_BOOK_TITLE);
        assertThat(books).containsOnlyOnce(firstBook);
    }

    @DisplayName("should update title book by her id")
    @Test
    void shouldUpdateBookNameById() {
        val firstBook = testEntityManager.find(Book.class,FIRST_BOOK_ID);
        String oldTitle = firstBook.getTitle();
        testEntityManager.detach(firstBook);

        repositoryJpa.updateTitleById(FIRST_BOOK_ID, TESTING_TITLE);
        val updateBook = testEntityManager.find(Book.class, FIRST_BOOK_ID);

        assertThat(updateBook.getTitle()).isNotEqualTo(oldTitle).isEqualTo(TESTING_TITLE);
    }

    @DisplayName("should delete book by her id")
    @Test
    void shouldDeleteNameById() {
        val firstBook = testEntityManager.find(Book.class, FIRST_BOOK_ID);
        assertThat(firstBook).isNotNull();
        testEntityManager.detach(firstBook);

        repositoryJpa.deleteById(FIRST_BOOK_ID);
        val deletedBook = testEntityManager.find(Book.class, FIRST_BOOK_ID);

        assertThat(deletedBook).isNull();
    }
}