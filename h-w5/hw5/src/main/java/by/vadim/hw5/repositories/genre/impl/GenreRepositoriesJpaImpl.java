package by.vadim.hw5.repositories.genre.impl;

import by.vadim.hw5.models.Genre;
import by.vadim.hw5.repositories.genre.GenreRepositories;
import lombok.val;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GenreRepositoriesJpaImpl implements GenreRepositories {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Genre save(Genre genre) {
        if (genre.getId() == 0){
            entityManager.persist(genre);
            return genre;
        } else {
            return entityManager.merge(genre);
        }
    }

    public List<Genre> findByName(String name){
        TypedQuery<Genre> query =
                entityManager.createQuery("select s from Genre s " +
                        "where s.name = :name", Genre.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void deleteById(long id) {
        val genre = entityManager.createQuery("select s from Genre s " +
                        "join fetch s.books where s.id = :id", Genre.class)
                .setParameter("id", id)
                .getSingleResult();

        entityManager.remove(genre);
    }
}
