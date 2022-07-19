package by.vadim.librarysystems.service.author;

import by.vadim.librarysystems.domain.Author;

import java.util.List;

public interface AuthorService {
    Author addNew(Author author);

    Author getById(long id);

    List<Author> getAll();

    void deleteById(long id);
}
