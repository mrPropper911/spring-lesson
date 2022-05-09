package by.vadim.hw4.service.author;

import by.vadim.hw4.domain.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();
    Author searchAuthorById(long id);
}
