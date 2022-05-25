package by.vadim.hw8.service.genre.impl;

import by.vadim.hw8.domain.Genre;
import by.vadim.hw8.repositories.genre.GenreRepositories;
import by.vadim.hw8.service.genre.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepositories genreRepositories;

    @Transactional
    @Override
    public List<Genre> getAllGenreList() {
        List<Genre> listGenre =
                StreamSupport.stream(genreRepositories
                        .findAll()
                        .spliterator(),false)
                        .collect(Collectors.toList());
        return listGenre;
    }
}
