package by.vadim.hw6.service.application.genre.impl;

import by.vadim.hw6.models.Genre;
import by.vadim.hw6.repositories.GenreRepositories;
import by.vadim.hw6.service.api.IOService;
import by.vadim.hw6.service.application.genre.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepositories genreRepositories;
    private final IOService ioService;

    @Override
    public void saveNewGenreInBd() {
        Genre genre = new Genre();
        ioService.out("Enter new genre name");
        String genreNameIn = ioService.readString();
        List<Genre> listGenre = (List<Genre>) genreRepositories.findAll();

        for (Genre index : listGenre) {
            if (index.getName().equals(genreNameIn)) {
                ioService.out("This author exists");
                return;
            }
        }

        genre.setName(genreNameIn);
        genreRepositories.save(genre);
    }

    @Override
    public void showAllGenreFromBd() {
        List<Genre> listGenre = (List<Genre>) genreRepositories.findAll();
        for (Genre index : listGenre) {
            ioService.out(messageGenre(index));
        }
    }

    @Override
    public void deleteGenreFromBd() {
        ioService.out("Enter id genre for delete");
        showAllGenreFromBd();

        long idGenreForDelete = Long.parseLong(ioService.readString());
        Optional<Genre> genre = genreRepositories.findById(idGenreForDelete);
        genreRepositories.deleteById(genre.orElseThrow().getId());
    }

    private String messageGenre(Genre genre) {
        String outStrGenre = "";
        return outStrGenre + " " + genre.getId() + " " + genre.getName();
    }
}