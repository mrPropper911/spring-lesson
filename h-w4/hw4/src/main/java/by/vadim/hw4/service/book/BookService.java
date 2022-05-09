package by.vadim.hw4.service.book;

import by.vadim.hw4.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book searchBookByID(long id);
    void addNewBook(Book book);
    void addNewBook(long id, String title, double price, long author_id, long genre_id);

    void deleteBookById(long id);
    void messageBook(Book book);
}
