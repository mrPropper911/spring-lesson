package by.vadim.librarysystems.service.book;

import by.vadim.librarysystems.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book getBookById(long id);
    List<Book> getAllBooks();
}
