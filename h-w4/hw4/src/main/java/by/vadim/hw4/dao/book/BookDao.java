package by.vadim.hw4.dao.book;

import by.vadim.hw4.domain.Book;

import java.util.List;

public interface BookDao {
    int count();

    int insert(long id, String title, double price, long author_id, long genre_id);

    List<Book> getAll();

    Book getById(long id);

    void deleteById(long id);
}
