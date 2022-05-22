package by.vadim.hw8.repositories.comment;

import by.vadim.hw8.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepositories extends CrudRepository<Comment, Long> {
}
