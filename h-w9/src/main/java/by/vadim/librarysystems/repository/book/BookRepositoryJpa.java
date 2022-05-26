package by.vadim.librarysystems.repository.book;

import by.vadim.librarysystems.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositoryJpa extends CrudRepository<Book, Long> {
}
