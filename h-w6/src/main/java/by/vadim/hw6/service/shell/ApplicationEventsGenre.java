package by.vadim.hw6.service.shell;

import by.vadim.hw6.service.application.genre.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@AllArgsConstructor
public class ApplicationEventsGenre {
    private final GenreService genreService;

    @ShellMethod(value = "Save new genre in BD", key = {"saveG", "save genre"})
    public void saveNewGenre() {
        genreService.saveNewGenreInBd();
    }

    @ShellMethod(value = "Show all genre from BD", key = {"showG", "show genre"})
    public void showAllGenre() {
        genreService.showAllGenreFromBd();
    }

    @ShellMethod(value = "Delete genre from BD by Id", key = {"deleteG", "delete genre"})
    public void deleteGenreById() {
        genreService.deleteGenreFromBd();
    }
}
