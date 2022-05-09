package by.vadim.hw4.dao.book;

import by.vadim.hw4.domain.Author;
import by.vadim.hw4.domain.Book;
import by.vadim.hw4.domain.Genre;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {
    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(JdbcOperations jdbc, NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = jdbc;
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from books", Integer.class);
    }

    @Override
    public int insert(long id, String title, double price, long author_id, long genre_id) {
        Map<String, Object> params = Map.of("id", id, "title",
                title, "price", price, "author_id", author_id, "genre_id", genre_id);
        return namedParameterJdbcOperations.update("update books set title = :title, price = :price," +
                " author_id = :author_id, genre_id = :genre_id where id = :id", params);
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select * from books " +
                "inner join authors on books.author_id = authors.id " +
                "inner join genres on books.genre_id = genres.id", new BookMapper());
    }

    @Override
    public Book getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject("select * from books " +
                "inner join authors on books.author_id = authors.id " +
                "inner join genres on books.genre_id = genres.id " +
                "where books.id = :id", params, new BookMapper());
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update("delete from books where id = :id", params);
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            final long id = rs.getLong("id");
            final String name = rs.getString("title");
            final double price = rs.getDouble("price");

            final long authorId = rs.getLong("author_id");
            final String authorName = rs.getString("name_authors");
            final Author author = new Author(authorId, authorName);

            final long genreId = rs.getLong("genre_id");
            final String genreName = rs.getString("name_genres");
            final Genre genre = new Genre(genreId, genreName);

            return new Book(id, name, price, author, genre);
        }
    }
}