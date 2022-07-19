package by.vadim.librarysystems.controller;

import by.vadim.librarysystems.domain.Book;
import by.vadim.librarysystems.service.book.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id){
        return bookService.getBookById(id);
    }

}
