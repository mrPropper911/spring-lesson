package by.vadim.librarysystems.repository.author;

import by.vadim.librarysystems.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface AuthorRepositoryJpa extends CrudRepository<Author, Long> {
}
