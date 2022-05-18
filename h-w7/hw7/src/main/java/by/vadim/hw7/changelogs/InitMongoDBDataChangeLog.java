package by.vadim.hw7.changelogs;

import by.vadim.hw7.models.Author;
import by.vadim.hw7.models.Book;
import by.vadim.hw7.models.Comment;
import by.vadim.hw7.models.Genre;
import by.vadim.hw7.repositories.author.AuthorRepository;
import by.vadim.hw7.repositories.book.BookRepository;
import by.vadim.hw7.repositories.CommentRepository;
import by.vadim.hw7.repositories.GenreRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;

@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {
    private Author aut1Author;
    private Author aut2Author;
    private Author aut4Author;

    private Genre genre1Genre;
    private Genre genre2Genre;
    private Genre genre3Genre;

    private Comment review1Comment;
    private Comment review2Comment;
    private Comment review3Comment;
    private Comment review4Comment;

    @ChangeSet(order = "000", id = "dropBD", author = "mrPropper911", runAlways = true)
    public void dropDB(MongoDatabase mongoDatabase) {
        mongoDatabase.drop();
    }

    @ChangeSet(order = "001", id = "initAuthors", author = "mrPropper911", runAlways = true)
    public void initAuthors(AuthorRepository authorRepository) {
        aut1Author = authorRepository.save(new Author("Булгаков М.А."));
        aut2Author = authorRepository.save(new Author("Достоевский Ф.М."));
        aut4Author = authorRepository.save(new Author("Пастернак Б.Л."));
    }

    @ChangeSet(order = "002", id = "initGenre", author = "mrPropper911", runAlways = true)
    public void initGenre(GenreRepository genreRepository) {
        genre1Genre = genreRepository.save(new Genre("Роман"));
        genre2Genre = genreRepository.save(new Genre("Поэма"));
        genre3Genre = genreRepository.save(new Genre("Басня"));
    }

    @ChangeSet(order = "003", id = "initComment", author = "mrPropper911", runAlways = true)
    public void initComment(CommentRepository commentRepository) {
        review1Comment = commentRepository.save(new Comment("Это шедевр искусства!"));
        review2Comment = commentRepository.save(new Comment("Класс но при частом употребление вызывает рвоту"));
        review3Comment = commentRepository.save(new Comment("Зря потраченное время"));
        review4Comment = commentRepository.save(new Comment("Отсутствие логики"));
    }

    @ChangeSet(order = "004", id = "initBook", author = "mrPropper911", runAlways = true)
    public void initBook(BookRepository bookRepository) {
        bookRepository.save(new Book("Дон Кихот", "412", aut4Author, genre1Genre, review1Comment, review2Comment));
        bookRepository.save(new Book("Календула", "22", aut1Author, genre2Genre, review3Comment));
        bookRepository.save(new Book("Логика", "122", aut2Author, genre3Genre, review4Comment));
    }
}
