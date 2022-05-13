package by.vadim.hw5.repositories.book;

import by.vadim.hw5.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    //todo create, read, update, delete
    Book save(Book book);
    Optional<Book> findById(long id);

    List<Book> findAll();
    List<Book> findByTitle(String name);

    void updateTitleById(long id, String name);
    void deleteById(long id);
}
