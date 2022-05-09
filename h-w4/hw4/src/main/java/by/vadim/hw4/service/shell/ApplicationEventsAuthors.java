package by.vadim.hw4.service.shell;

import by.vadim.hw4.domain.Author;
import by.vadim.hw4.service.api.IOService;
import by.vadim.hw4.service.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsAuthors {
    private final IOService ioService;
    private final AuthorService authorService;

    @ShellMethod(value = "Login command", key = {"l", "login"})
    public String sayHello(@ShellOption(defaultValue = "Vadim") String username) {
        return String.format("Hello: %s", username);
    }

    @ShellMethod(value = "Get all authors", key = {"saa", "show all authors"})
    public void showAuthor() {
        List<Author> authorList = authorService.getAll();
        for (Author index : authorList) {
            ioService.out(index.getId() + " " + index.getName());
        }
    }

    @ShellMethod(value = "Show authors by  id", key = {"saaID", "show found authors"})
    public void showAuthorById(@ShellOption(defaultValue = "1") long searchId) {
        ioService.out(authorService.searchAuthorById(searchId).getId() + " " +
                authorService.searchAuthorById(searchId).getName());
    }

}
