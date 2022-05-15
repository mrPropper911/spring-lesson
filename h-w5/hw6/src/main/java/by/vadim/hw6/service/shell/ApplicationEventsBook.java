package by.vadim.hw6.service.shell;

import by.vadim.hw6.service.application.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsBook {
    private final BookService bookService;

    @ShellMethod(value = "Save new book in BD", key = {"saveB", "save book"})
    public void saveNewBook() {
        bookService.saveNewBook();
    }

    @ShellMethod(value = "Show all book from DB", key = {"showAllB", "show book"})
    public void showAllBook() {
        bookService.showAllBook();
    }

    @ShellMethod(value = "Search book by Title", key = {"searchB", "search book"})
    public void searchBookByTitle() {
        bookService.findBookByName();
    }

    @ShellMethod(value = "Update title book by Id", key = {"updateB", "update title book"})
    public void updateBookTitleById() {
        bookService.updateTitleBookById();
    }

    @ShellMethod(value = "Delete book by id", key = {"deleteB", "delete book"})
    public void deleteBookById() {
        bookService.deleteBookById();
    }
}