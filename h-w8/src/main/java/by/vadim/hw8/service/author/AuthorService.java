package by.vadim.hw8.service.author;

import by.vadim.hw8.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author saveNewAuthor(Author author);

    List<Author> getAllAuthorList();

    Author updateAuthor(Author author);

    Optional<Author> findAuthorById(long id);

    void deleteAuthorById(long id);
}
