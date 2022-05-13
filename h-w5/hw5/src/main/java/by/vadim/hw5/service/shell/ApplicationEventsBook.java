package by.vadim.hw5.service.shell;

import by.vadim.hw5.service.api.IOService;
import by.vadim.hw5.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsBook {
    private final IOService ioService;
    private final BookService bookService;

    @ShellMethod(value = "Save new book in BD", key = {"sB", "save book"})
    public void saveNewBook(){
        bookService.saveNewBook();
    }

    @ShellMethod(value = "Show all book from DB", key = {"shB", "show book"})
    public void showAllBook(){
        bookService.showAllBook();
    }

    @ShellMethod(value = "Search book by Title", key = {"srB", "search book"})
    public void searchBookByTitle(){
        bookService.findBookByName();
    }
}
