package by.vadim.hw4.dao.genre;

import by.vadim.hw4.domain.Genre;

import java.util.List;

public interface GenreDAO {
    int count();

    void insert(Genre genre);

    List<Genre> getAll();

    Genre getById(long id);

    void deleteById(long id);
}
