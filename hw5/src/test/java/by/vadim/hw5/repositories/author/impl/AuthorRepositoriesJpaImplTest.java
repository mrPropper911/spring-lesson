package by.vadim.hw5.repositories.author.impl;

import by.vadim.hw5.models.Author;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(AuthorRepositoriesJpaImpl.class)
class AuthorRepositoriesJpaImplTest {
    private static final long FIRST_AUTHOR_ID = 1L;
    private static final String AUTHOR_NAME = "Булгаков М.А.";
    private static final String AUTHOR_NAME_NEW = "Selin М.А.";

    @Autowired
    AuthorRepositoriesJpaImpl repositoriesJpa;

    @Autowired
    TestEntityManager testEntityManager;

    @DisplayName("should save all information about author")
    @Test
    void shouldSaveAuthorAllInformation() {
        val author = new Author();
        author.setName(AUTHOR_NAME_NEW);

        repositoriesJpa.save(author);
        assertThat(author.getId()).isGreaterThan(0);

        val actualAutor = testEntityManager.find(Author.class, author.getId());
        assertThat(actualAutor).isNotNull()
                .matches(s -> !s.getName().equals(""));
    }

    @DisplayName("should return information about author for him name")
    @Test
    void shouldFindExpectedAuthorByTitle() {
        val firstAuthor = testEntityManager.find(Author.class, FIRST_AUTHOR_ID);
        List<Author> author = repositoriesJpa.findByName(AUTHOR_NAME);
        assertThat(author).containsOnlyOnce(firstAuthor);
    }

    @DisplayName("should delete author by id")
    @Test
    void shouldDeleteAuthorById() {
        val firstAuthor = testEntityManager.find(Author.class, FIRST_AUTHOR_ID);
        assertThat(firstAuthor).isNotNull();
        testEntityManager.detach(firstAuthor);

        repositoriesJpa.deleteById(FIRST_AUTHOR_ID);
        val deleteAuthor = testEntityManager.find(Author.class, FIRST_AUTHOR_ID);

        assertThat(deleteAuthor).isNull();
    }
}