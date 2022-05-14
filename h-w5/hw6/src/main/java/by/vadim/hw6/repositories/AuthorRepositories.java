package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {}
