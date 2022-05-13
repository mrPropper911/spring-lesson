package by.vadim.hw5.repositories.author.impl;

import by.vadim.hw5.models.Author;
import by.vadim.hw5.repositories.author.AuthorRepositories;
import lombok.val;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AuthorRepositoriesJpaImpl implements AuthorRepositories {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Author save(Author author) {
        if (author.getId() == 0){
            entityManager.persist(author);
            return author;
        } else {
            return entityManager.merge(author);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query =
                entityManager.createQuery("select s from Author s " +
                        "where s.name = :name", Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }


    @Transactional
    @Override
    public void deleteById(long id) {
        val genre = entityManager.createQuery("select s from Author s " +
                        "join fetch s.books where s.id = :id", Author.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.remove(genre);
    }
}
