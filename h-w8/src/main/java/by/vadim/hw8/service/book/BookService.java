package by.vadim.hw8.service.book;

import by.vadim.hw8.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book saveNewBook(Book book);

    List<Book> getAllBookList();

    List<Book> searchBookByName(String searchName);

    Optional<Book> findBookById(long id);

    Book updateBook(Book book);

    void deleteBookById(long id);
}
