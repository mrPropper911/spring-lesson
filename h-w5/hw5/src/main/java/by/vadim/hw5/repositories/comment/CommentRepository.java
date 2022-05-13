package by.vadim.hw5.repositories.comment;

import by.vadim.hw5.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);

    Optional<Comment> findById(long id);

    List<Comment> findAllCommentsByBookId(long id);

    void updateCommentById(long id, String comment);

    void deleteByID(long id);
}
