package by.vadim.librarysystems.service.book.impl;

import by.vadim.librarysystems.domain.Book;
import by.vadim.librarysystems.repository.book.BookRepositoryJpa;
import by.vadim.librarysystems.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositoryJpa bookRepositoryJpa;

    @Transactional
    @Override
    public Book getBookById(long id){
        return bookRepositoryJpa.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    @Override
    public List<Book> getAllBooks() {
        return StreamSupport.stream(bookRepositoryJpa
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }
}
