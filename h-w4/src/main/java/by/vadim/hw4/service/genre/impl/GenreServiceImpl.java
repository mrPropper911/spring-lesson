package by.vadim.hw4.service.genre.impl;

import by.vadim.hw4.dao.genre.GenreDAO;
import by.vadim.hw4.domain.Genre;
import by.vadim.hw4.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDAO genreDAO;

    @Override
    public List<Genre> getAll() {
        return genreDAO.getAll();
    }
}
