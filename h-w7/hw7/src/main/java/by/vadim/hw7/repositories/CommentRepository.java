package by.vadim.hw7.repositories;

import by.vadim.hw7.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
