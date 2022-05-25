package by.vadim.hw8.service.book.impl;

import by.vadim.hw8.domain.Book;
import by.vadim.hw8.repositories.book.BookRepositories;
import by.vadim.hw8.repositories.book.BookRepositoriesJpa;
import by.vadim.hw8.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositories bookRepositories;
    private final BookRepositoriesJpa bookRepositoriesJpa;

    @Transactional
    @Override
    public Book saveNewBook(Book book) {
        Book savedBook = bookRepositories.save(book);
        return savedBook;
    }

    @Transactional
    @Override
    public List<Book> getAllBookList() {
        List<Book> bookList =
                StreamSupport.stream(bookRepositories
                                .findAll()
                                .spliterator(), false)
                        .collect(Collectors.toList());
        ;
        return bookList;
    }

    @Transactional
    @Override
    public List<Book> searchBookByName(String searchName) {
        return bookRepositoriesJpa.findBooksByTitleContainingIgnoreCase(searchName);
    }

    @Transactional
    @Override
    public Optional<Book> findBookById(long id) {
        return bookRepositories.findById(id);
    }

    @Transactional
    @Override
    public Book updateBook(Book book) {
        bookRepositoriesJpa.updateBook(book.getId(), book.getTitle(), book.getPrice(),
                book.getAuthor().getId(), book.getGenre().getId());
        return book;
    }

    @Transactional
    @Override
    public void deleteBookById(long id) {
        bookRepositories.deleteById(id);
    }
}
