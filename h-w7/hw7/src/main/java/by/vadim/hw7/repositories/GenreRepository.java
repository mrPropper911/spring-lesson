package by.vadim.hw7.repositories;

import by.vadim.hw7.models.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
