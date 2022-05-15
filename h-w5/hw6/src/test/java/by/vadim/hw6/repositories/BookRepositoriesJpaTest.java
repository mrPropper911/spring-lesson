package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Book;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RepositoryJpa check for work with BOOKS ")
@DataJpaTest
class BookRepositoriesJpaTest {
    private static final long FIRST_BOOK_ID = 1L;
    private static final String TESTING_TITLE = "Testing title";

    @Autowired
    private BookRepositoriesJpa repositoryJpa;

    @Autowired
    private TestEntityManager testEntityManager;

    @DisplayName("should update title book by her id")
    @Test
    void shouldUpdateBookNameById() {
        val firstBook = testEntityManager.find(Book.class,FIRST_BOOK_ID);
        String oldTitle = firstBook.getTitle();
        testEntityManager.detach(firstBook);

        repositoryJpa.updateTitleBook(FIRST_BOOK_ID, TESTING_TITLE);
        val updateBook = testEntityManager.find(Book.class, FIRST_BOOK_ID);

        assertThat(updateBook.getTitle()).isNotEqualTo(oldTitle).isEqualTo(TESTING_TITLE);
    }
}