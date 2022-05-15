package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Book;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Repository check for work with BOOKS ")
@DataJpaTest
class BookRepositoriesTest {
    private static final long FIRST_BOOK_ID = 1L;
    private static final String FIRST_BOOK_TITLE = "Дон Кихот";

    @Autowired
    private BookRepositories bookRepositories;

    @Autowired
    private TestEntityManager testEntityManager;

    @DisplayName("should return information about book for her title")
    @Test
    void shouldFindExpectedBookByTitle() {
        val firstBook = testEntityManager.find(Book.class, FIRST_BOOK_ID);
        Book book = bookRepositories.findByTitle(FIRST_BOOK_TITLE);
        assertThat(book).isEqualTo(firstBook);
    }
}