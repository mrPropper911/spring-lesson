package by.vadim.hw4.dao.book;

import by.vadim.hw4.domain.Author;
import by.vadim.hw4.domain.Book;
import by.vadim.hw4.domain.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JdbcTest
@Import(BookDaoJdbc.class)
@DisplayName("DAO for work with Book must")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BookDaoJdbcTest {
    private static final int EXPECTED_PERSONS_COUNT = 2;
    private static final int EXPECTED_PERSONS_COUNT_AFTER_DELETE = 1;
    private static final long DON_KAHOOT_ID = 1L;
    private static final String DON_KAHOOT_TITLE = "Дон Кихот";

    @Autowired
    private BookDaoJdbc bookDaoJdbc;

    @DisplayName("return expected count of book in BD")
    @Test
    void shouldReturnExpectedBookCount() {
        int count = bookDaoJdbc.count();
        assertThat(count).isEqualTo(EXPECTED_PERSONS_COUNT);
    }

    @DisplayName("insert book in BD")
    @Test
    void shouldInsertBook() {
        Author author = new Author(1, "Булгаков М.А.");
        Genre genre = new Genre(1, "Роман");
        Book expectedBook = new Book(1, "Логирование", 1, author, genre);

        bookDaoJdbc.insert(1, "Логирование", 1, 1, 1);
        Book actualBook = bookDaoJdbc.getById(expectedBook.getId());
        assertThat(actualBook).isEqualTo(expectedBook);
    }

    @DisplayName("return expected List with all Book from DB")
    @Test
    void shouldReturnListWithAllBook() {
        List<Book> bookListExpected = new ArrayList<Book>();
        List<Book> bookListActual = new ArrayList<Book>();

        Author author1 = new Author(1, "Булгаков М.А.");
        Author author2 = new Author(2, "Достоевский Ф.М.");
        Genre genre1 = new Genre(1, "Роман");
        Genre genre2 = new Genre(2, "Поэма");

        bookListExpected.add(new Book(1, "Дон Кихот", 1, author1, genre1));
        bookListExpected.add(new Book(2, "Календула", 2, author2, genre2));

        bookListActual = bookDaoJdbc.getAll();

        assertThat(bookListActual.hashCode()).isEqualTo(bookListExpected.hashCode());
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @DisplayName("return expected Book from him ID")
    @Test
    void shouldReturnExpectedBookById() {
        Book actualBook = bookDaoJdbc.getById(DON_KAHOOT_ID);
        assertThat(actualBook)
                .hasFieldOrPropertyWithValue("id", DON_KAHOOT_ID)
                .hasFieldOrPropertyWithValue("title", DON_KAHOOT_TITLE);
    }

    @DisplayName("sould delete book from DB")
    @Test
    void shouldDeleteBookById() {
        bookDaoJdbc.deleteById(2);
        int count = bookDaoJdbc.count();
        assertThat(count).isEqualTo(EXPECTED_PERSONS_COUNT_AFTER_DELETE);
    }
}