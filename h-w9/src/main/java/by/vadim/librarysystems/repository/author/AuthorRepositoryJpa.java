package by.vadim.librarysystems.repository.author;

import by.vadim.librarysystems.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositoryJpa extends CrudRepository<Author, Long> {
}
