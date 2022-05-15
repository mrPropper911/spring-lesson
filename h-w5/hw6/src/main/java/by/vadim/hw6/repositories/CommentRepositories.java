package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepositories extends CrudRepository<Comment, Long> {
    List<Comment> findCommentByBook_Id(long idOfBook);
}
