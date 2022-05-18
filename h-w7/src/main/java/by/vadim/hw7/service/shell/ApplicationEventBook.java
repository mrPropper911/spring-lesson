package by.vadim.hw7.service.shell;

import by.vadim.hw7.repositories.CommentRepository;
import by.vadim.hw7.repositories.book.BookRepository;
import by.vadim.hw7.service.application.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;


import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventBook {
    private final BookService bookService;
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @ShellMethod(value = "Show all book from DB", key = {"showAllB", "show book"})
    public void showAllBook() {
        bookService.showAllBook();
    }

    @ShellMethod(value = "Test deleting", key = {"test", "delete test"})
    public void deleteTest() {
        //for test buffereader
        String test = "qwe2\nqda1\n\n";
        Reader inputString = new StringReader(test);
        BufferedReader reader = new BufferedReader(inputString);
    }
}
