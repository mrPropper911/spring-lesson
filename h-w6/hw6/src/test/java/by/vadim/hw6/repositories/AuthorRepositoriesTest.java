package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Author;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Repository check for work with AUTHORS ")
@DataJpaTest
class AuthorRepositoriesTest {
    private static final long FIRST_AUTHOR_ID = 1L;
    private static final String AUTHOR_NAME = "Булгаков М.А.";

    @Autowired
    AuthorRepositories repositoriesJpa;

    @Autowired
    TestEntityManager testEntityManager;

    @DisplayName("should return information about author for him name")
    @Test
    void shouldFindExpectedAuthorByTitle() {
        val firstAuthor = testEntityManager.find(Author.class, FIRST_AUTHOR_ID);
        Author author = repositoriesJpa.findByName(AUTHOR_NAME);
        assertThat(author).isEqualTo(firstAuthor);
    }
}