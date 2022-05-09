package by.vadim.hw4.service.shell;

import by.vadim.hw4.domain.Author;
import by.vadim.hw4.domain.Genre;
import by.vadim.hw4.service.api.IOService;
import by.vadim.hw4.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationEventsGenres {
    private final IOService ioService;
    private final GenreService genreService;

    @ShellMethod(value = "Get all genres", key = {"sag", "show all genres"})
    public void showAuthor(){
        List<Genre> genreList = genreService.getAll();
        for (Genre index: genreList){
            ioService.out(index.getId() + " " + index.getName());
        }
    }
}
