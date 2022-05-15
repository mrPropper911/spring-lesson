package by.vadim.hw4.service.shell;

import by.vadim.hw4.domain.Book;
import by.vadim.hw4.service.api.IOService;
import by.vadim.hw4.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsBooks {
    private final BookService bookService;
    private final IOService ioService;

    @ShellMethod(value = "Get all book", key = {"sab", "show all book"})
    public void showBook() {
        List<Book> bookList = bookService.getAllBooks();
        for (Book index : bookList) {
            bookService.messageBook(index);
        }
    }

    @ShellMethod(value = "Search book by ID", key = {"sabID", "show found book"})
    public void showFoundBook(@ShellOption(defaultValue = "1") long searchId) {
        bookService.messageBook(bookService.searchBookByID(searchId));
    }

    @ShellMethod(value = "Delete book by ID", key = {"dabID", "delete found book"})
    public void deleteFoundBook(long searchId) {
        bookService.deleteBookById(searchId);
        ioService.out("Delete succeed!");
    }

    @ShellMethod(value = "Add book new book", key = {"aab", "update book"})
    public void addNewBook() {
        ioService.out("Enter id:");
        final Long id = Long.parseLong(ioService.readString());
        ioService.out("Enter title:");
        final String title = ioService.readString();
        ioService.out("Enter price:");
        final double price = Double.parseDouble(ioService.readString());
        ioService.out("Enter author_id:");
        final Long author_id = Long.parseLong(ioService.readString());
        ioService.out("Enter genre_id:");
        final Long genre_id = Long.parseLong(ioService.readString());

        bookService.addNewBook(id, title, price, author_id, genre_id);
        ioService.out("Add succeed!");
    }
}
