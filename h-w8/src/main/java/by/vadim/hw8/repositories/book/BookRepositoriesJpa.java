package by.vadim.hw8.repositories.book;

import by.vadim.hw8.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepositoriesJpa extends JpaRepository<Book, Long> {

    @Modifying
    @Query("update Book as s set s.title = :title, s.price = :price, s.author.id = :author_id, s.genre.id = :genre_id where s.id = :id")
    void updateBook(@Param("id") long id,
                    @Param("title") String title,
                    @Param("price") double price,
                    @Param("author_id") long author_id,
                    @Param("genre_id") long genre_id
    );

    List<Book> findBooksByTitleContainingIgnoreCase(String searchTitle);
}
