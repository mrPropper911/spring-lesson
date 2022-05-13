package by.vadim.hw5.repositories.author;

import by.vadim.hw5.models.Author;

import java.util.List;

public interface AuthorRepositories {
    Author save(Author author);
    List<Author> findByName(String name);
    List<Author> findAll();
    void deleteById(long id);
}
