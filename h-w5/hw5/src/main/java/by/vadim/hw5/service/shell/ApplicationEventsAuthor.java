package by.vadim.hw5.service.shell;

import by.vadim.hw5.service.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsAuthor {
    private final AuthorService authorService;

    @ShellMethod(value = "Save new author in BD", key = {"sA", "save author"})
    public void saveNewAuthor(){
        authorService.saveNewAuthor();
    }

    @ShellMethod(value = "Show all authors from BD", key = {"shA", "show authors"})
    public void showAllAuthor(){
        authorService.showAllAuthor();
    }
}
