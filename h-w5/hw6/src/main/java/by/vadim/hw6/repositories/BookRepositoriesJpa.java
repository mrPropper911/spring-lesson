package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepositoriesJpa extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying
    @Query("update Book s set s.title = :title where s.id = :id")
    void updateTitleBook(@Param("id") long id, @Param("title") String title);
}
