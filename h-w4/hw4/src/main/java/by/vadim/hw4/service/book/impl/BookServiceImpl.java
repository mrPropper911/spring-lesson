package by.vadim.hw4.service.book.impl;

import by.vadim.hw4.dao.book.BookDao;
import by.vadim.hw4.domain.Book;
import by.vadim.hw4.service.api.IOService;
import by.vadim.hw4.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final IOService ioService;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAll();
    }

    @Override
    public Book searchBookByID(long id) {
        return bookDao.getById(id);
    }

    @Override
    public void addNewBook(Book book) {
        bookDao.insert(book.getId(), book.getTitle(), book.getPrice(),
                book.getAuthor().getId(), book.getGenre().getId());
    }
    @Override
    public void addNewBook(long id, String title, double price, long author_id, long genre_id) {
        bookDao.insert(id, title, price, author_id, genre_id);
    }

    @Override
    public void deleteBookById(long id) {
        bookDao.deleteById(id);
    }

    public void messageBook(Book book){
        ioService.out(book.getId() + ") " + book.getTitle() + " " +
                book.getPrice() + " " + book.getAuthor().getName() + " " + book.getGenre().getName());
    }
}