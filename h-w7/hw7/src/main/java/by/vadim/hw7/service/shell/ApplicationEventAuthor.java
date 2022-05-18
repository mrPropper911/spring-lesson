package by.vadim.hw7.service.shell;

import by.vadim.hw7.service.application.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventAuthor {
    private final AuthorService authorService;

    @ShellMethod(value = "Save new author in BD", key = {"saveA", "save author"})
    public void saveNewAuthor() {
        authorService.saveNewAuthorInBd();
    }

    @ShellMethod(value = "Show all authors from BD", key = {"showA", "show authors"})
    public void showAllAuthor() {
        authorService.showAllAuthorFromBd();
    }

    @ShellMethod(value = "Delete authors from BD by Id", key = {"deleteA", "delete authors"})
    public void deleteAuthorById() {
        authorService.deleteAuthorFromBd();
    }
}
