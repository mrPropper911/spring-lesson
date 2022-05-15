package by.vadim.hw6.service.application.book.impl;

import by.vadim.hw6.models.Author;
import by.vadim.hw6.models.Book;
import by.vadim.hw6.models.Comment;
import by.vadim.hw6.models.Genre;
import by.vadim.hw6.repositories.AuthorRepositories;
import by.vadim.hw6.repositories.BookRepositories;
import by.vadim.hw6.repositories.BookRepositoriesJpa;
import by.vadim.hw6.repositories.GenreRepositories;
import by.vadim.hw6.service.api.IOService;
import by.vadim.hw6.service.application.book.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositories bookRepositories;
    private final AuthorRepositories authorRepositories;
    private final GenreRepositories genreRepositories;
    private final IOService ioService;

    @Autowired
    private final BookRepositoriesJpa bookRepositoriesJpa;

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
        if (inName.isEmpty()) {
            ioService.out("Name is empty");
            return;
        }
        Author author = new Author();
        Author authorSearch = authorRepositories.findByName(inName);

        if (authorSearch == null) {
            author.setName(inName);
            authorRepositories.save(author);
            book.setAuthor(author);
        } else {
            author.setId(author.getId());
            author.setName(author.getName());
            book.setAuthor(author);
        }

        ioService.out("Enter name genre of book");
        String inGenre = ioService.readString();
        Genre genre = new Genre();
        Genre genreSearch = genreRepositories.findByName(inGenre);

        if (genreSearch == null) {
            genre.setName(inGenre);
            genreRepositories.save(genre);
            book.setGenre(genre);
        } else {
            genre.setId(genreSearch.getId());
            genre.setName(genreSearch.getName());
            book.setGenre(genre);
        }

        ioService.out("Enter comment to the book");
        String inComments = ioService.readString();
        Comment comment = new Comment(0, inComments, book);
        List<Comment> comments = Collections.singletonList(comment);
        book.setComments(comments);

        bookRepositories.save(book);
    }

    @Override
    public void showAllBook() {
        List<Book> bookList = (List<Book>) bookRepositories.findAll();
        for (Book index : bookList) {
            ioService.out(messageBook(index));
        }
    }

    @Override
    public void findBookByName() {
        ioService.out("Enter title to search");
        String searchTitle = ioService.readString();
        Book book = bookRepositories.findByTitle(searchTitle);
        if (book == null) {
            ioService.out("Not founded");
        } else {
            ioService.out(messageBook(book));
        }
    }

    @Transactional
    @Override
    public void updateTitleBookById() {
        ioService.out("Enter id to update book");
        long idUpdate = Long.parseLong(ioService.readString());
        ioService.out("Enter new title to update");
        String updateTitle = ioService.readString();
        bookRepositoriesJpa.updateTitleBook(idUpdate, updateTitle);
    }

    @Override
    public void deleteBookById() {
        showAllBook();
        ioService.out("Enter id to delete book");
        long idDelete = Long.parseLong(ioService.readString());
        bookRepositories.deleteById(idDelete);
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
