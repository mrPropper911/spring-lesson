package by.vadim.hw8.repositories.author;

import by.vadim.hw8.domain.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
    List<Author> findAll();
}
