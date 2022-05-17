package by.vadim.hw7.repositories;

import by.vadim.hw7.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
