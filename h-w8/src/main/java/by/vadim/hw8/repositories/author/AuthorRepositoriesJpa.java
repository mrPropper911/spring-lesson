package by.vadim.hw8.repositories.author;

import by.vadim.hw8.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepositoriesJpa extends JpaRepository<Author, Long> {

    @Modifying
    @Query("update Author as s set s.name = :name where s.id = :id")
    void updateAuthor(@Param("id") long id,
                      @Param("name") String name);
}
