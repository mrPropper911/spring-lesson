package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepositories extends CrudRepository<Genre, Long> {}
