package by.vadim.hw4.dao.author;

import by.vadim.hw4.domain.Author;

import java.util.List;

public interface AuthorDao {
    int count();
    void insert(Author author);
    List<Author> getAll();
    Author getById(long id);
    void deleteById(long id);


}
