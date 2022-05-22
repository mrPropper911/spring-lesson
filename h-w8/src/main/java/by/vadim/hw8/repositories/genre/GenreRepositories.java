package by.vadim.hw8.repositories.genre;

import by.vadim.hw8.domain.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepositories extends CrudRepository<Genre, Long> {
    List<Genre> findAll();
}
