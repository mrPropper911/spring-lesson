package by.vadim.hw5.repositories.book.impl;

import by.vadim.hw5.models.Book;
import by.vadim.hw5.repositories.book.BookRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpaImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Book save(Book book) {
        if (book.getId() == 0) {
            if (book.getAuthor().getId() != 0) {
                entityManager.merge(book);
            } else {
                entityManager.persist(book.getAuthor());
                entityManager.persist(book.getGenre());
                entityManager.persist(book);
            }
            return book;
        } else {
            return entityManager.merge(book);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> findById(long id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findAll() {
        //write joins for N+1 trouble
        TypedQuery<Book> query =
                entityManager.createQuery("select s from Book s " +
                        "join fetch s.author join fetch s.genre", Book.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query =
                entityManager.createQuery("select s from Book s " +
                        "where s.title = :title", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void updateTitleById(long id, String title) {
        Query query =
                entityManager.createQuery("update Book s set s.title = :title where s.id = :id");
        query.setParameter("title", title);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        Query query =
                entityManager.createQuery("delete from Book s where s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
