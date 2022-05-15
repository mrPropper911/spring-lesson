package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Author;
import by.vadim.hw6.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
    Author findByName(String searchName);
}
