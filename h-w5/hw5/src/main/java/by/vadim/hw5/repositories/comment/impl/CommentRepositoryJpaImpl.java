package by.vadim.hw5.repositories.comment.impl;

import by.vadim.hw5.models.Comment;
import by.vadim.hw5.repositories.comment.CommentRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepositoryJpaImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Comment save(Comment comment) {
        if (comment.getId() == 0) {
            entityManager.persist(comment);
            return comment;
        } else {
            return entityManager.merge(comment);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Comment> findById(long id) {
        return Optional.ofNullable(entityManager.find(Comment.class, id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> findAllCommentsByBookId(long id) {
        TypedQuery<Comment> typedQuery =
                entityManager.createQuery("select s from Comment s left join s.book b where b.id = :id", Comment.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList();
    }

    @Transactional
    @Override
    public void updateCommentById(long id, String comment) {
        Query query =
                entityManager.createQuery("update Comment s set s.comment = :comment where s.id = :id");
        query.setParameter("comment", comment);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    @Override
    public void deleteByID(long id) {
        Query query =
                entityManager.createQuery("delete from Comment s where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
