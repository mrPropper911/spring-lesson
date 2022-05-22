package by.vadim.hw8.service.author;

import by.vadim.hw8.domain.Author;

import java.util.List;

public interface AuthorService {
    void saveNewAuthor();

    void showAllAuthor();

    List<Author> getAllAuthorList();
}
