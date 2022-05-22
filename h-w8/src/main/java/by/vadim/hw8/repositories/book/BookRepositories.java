package by.vadim.hw8.repositories.book;

import by.vadim.hw8.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepositories extends CrudRepository<Book, Long> {
    List<Book> findAll();

}
