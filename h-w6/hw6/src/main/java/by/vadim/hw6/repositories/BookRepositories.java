package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositories extends CrudRepository<Book, Long> {
    Book findByTitle(String searchName);

}
