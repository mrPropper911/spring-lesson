package by.vadim.hw5.repositories.genre;

import by.vadim.hw5.models.Genre;

import java.util.List;

public interface GenreRepositories {
    Genre save(Genre genre);

    List<Genre> findByName(String name);

    void deleteById(long id);
}
