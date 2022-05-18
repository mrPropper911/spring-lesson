package by.vadim.hw5.repositories.genre.impl;

import by.vadim.hw5.models.Genre;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Repository check for work with GENRES ")
@Import(GenreRepositoriesJpaImpl.class)
@DataJpaTest
class GenreRepositoriesJpaImplTest {

    private static final long FIRST_GENRE_ID = 1L;
    public static final String GENRE_NAME_NEW = "Historical";
    public static final String GENRE_NAME = "Роман";

    @Autowired
    GenreRepositoriesJpaImpl genreRepositoriesJpa;

    @Autowired
    TestEntityManager testEntityManager;

    @DisplayName("should save all information about genre")
    @Test
    void shouldSaveGenreAllInfornmation(){
        val genre = new Genre();
        genre.setName(GENRE_NAME_NEW);

        genreRepositoriesJpa.save(genre);
        assertThat(genre.getId()).isGreaterThan(0);

        val actualGenre = testEntityManager.find(Genre.class, genre.getId());
        assertThat(actualGenre).isNotNull()
                .matches(s -> !s.getName().equals(""));
    }

    @DisplayName("should return information about genre for him name")
    @Test
    void shouldFindExpectedAuthorByTitle() {
        val firstGenre = testEntityManager.find(Genre.class, FIRST_GENRE_ID);
        List<Genre> genres = genreRepositoriesJpa.findByName(GENRE_NAME);
        assertThat(genres).containsOnlyOnce(firstGenre);
    }

    @DisplayName("should cascade delete genre by Id")
    @Test
    void shouldDeleteGenreById() {
        val firstGenre = testEntityManager.find(Genre.class, FIRST_GENRE_ID);
        assertThat(firstGenre).isNotNull();
        testEntityManager.detach(firstGenre);

        genreRepositoriesJpa.deleteById(FIRST_GENRE_ID);
        val deleteGenre = testEntityManager.find(Genre.class,FIRST_GENRE_ID);

        assertThat(deleteGenre).isNull();
    }
}