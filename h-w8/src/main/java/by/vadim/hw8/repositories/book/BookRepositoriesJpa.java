package by.vadim.hw8.repositories.book;

import by.vadim.hw8.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepositoriesJpa extends JpaRepository<Book, Long> {

    @Modifying
    @Query("update Book as s set s.title = :title, s.price = :price where s.id = :id")
    void updateBook(@Param("id") long id,
                    @Param("title") String title,
                    @Param("price") double price);
}
