package by.vadim.hw5.service.book.impl;

import by.vadim.hw5.models.Author;
import by.vadim.hw5.models.Book;
import by.vadim.hw5.models.Comment;
import by.vadim.hw5.models.Genre;
import by.vadim.hw5.repositories.author.AuthorRepositories;
import by.vadim.hw5.repositories.book.BookRepository;
import by.vadim.hw5.repositories.genre.GenreRepositories;
import by.vadim.hw5.service.api.IOService;
import by.vadim.hw5.service.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepositoryJpa;
    private final AuthorRepositories authorRepositoriesJpa;
    private final GenreRepositories genreRepositoriesJpa;
    private final IOService ioService;

    @Override
    public void saveNewBook() {
        Book book = new Book();

        ioService.out("Enter title of book");
        String inTitle = ioService.readString();
        book.setTitle(inTitle);

        ioService.out("Enter price of book");
        double inPrice = Double.parseDouble(ioService.readString());
        book.setPrice(inPrice);

        ioService.out("Enter name author of book");
        String inName = ioService.readString();
        Author author = new Author();
        List<Author> authorList = authorRepositoriesJpa.findByName(inName);

        if (authorList.size() == 0) {
            author.setName(inName);
            book.setAuthor(author);
        } else {
            author.setId(authorList.get(0).getId());
            author.setName(authorList.get(0).getName());
            book.setAuthor(author);
        }

        ioService.out("Enter name genre of book");
        String inGenre = ioService.readString();
        Genre genre = new Genre();
        List<Genre> genreList = genreRepositoriesJpa.findByName(inGenre);

        if (genreList.size() == 0) {
            genre.setName(inGenre);
            book.setGenre(genre);
        } else {
            genre.setId(genreList.get(0).getId());
            genre.setName(genreList.get(0).getName());
            book.setGenre(genre);
        }

        ioService.out("Enter comment to the book");
        String inComments = ioService.readString();
        Comment comment = new Comment(0, inComments, book);
        List<Comment> comments = Collections.singletonList(comment);
        book.setComments(comments);

        bookRepositoryJpa.save(book);
    }

    @Override
    public void showAllBook() {
        List<Book> bookList = bookRepositoryJpa.findAll();
        for (Book index : bookList) {
            ioService.out(messageBook(index));
        }
    }

    @Override
    public void findBookByName() {
        ioService.out("Enter title to search");
        String searchTitle = ioService.readString();
        List<Book> listBook = bookRepositoryJpa.findByTitle(searchTitle);
        if (listBook.size() == 0) {
            ioService.out("Not founded");
        } else {
            for (Book index : listBook) {
                ioService.out(messageBook(index));
            }
        }
    }

    @Override
    public void updateTitleBookById() {
        ioService.out("Enter id to update book");
        long idDelete = Long.parseLong(ioService.readString());
        ioService.out("Enter new title to update");
        String searchTitle = ioService.readString();
        bookRepositoryJpa.updateTitleById(idDelete, searchTitle);
    }

    @Override
    public void deleteBookById() {
        showAllBook();
        ioService.out("Enter id to delete book");
        long idDelete = Long.parseLong(ioService.readString());
        bookRepositoryJpa.deleteById(idDelete);
    }

    private String messageBook(Book book) {
        String bookOut = "";
        bookOut = book.getId() + " " + book.getTitle() + " " +
                book.getPrice() + " " + book.getAuthor().getName() + " " + book.getGenre().getName() + "\n ";

        for (Comment index : book.getComments()) {
            bookOut += index.getComment() + "\n ";
        }
        return bookOut;
    }
}
