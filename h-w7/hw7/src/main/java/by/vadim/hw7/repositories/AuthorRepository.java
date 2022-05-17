package by.vadim.hw7.repositories;

import by.vadim.hw7.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
