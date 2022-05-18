package by.vadim.hw7.service.application.book.impl;

import by.vadim.hw7.models.Book;
import by.vadim.hw7.models.Comment;
import by.vadim.hw7.repositories.book.BookRepository;
import by.vadim.hw7.service.api.IOService;
import by.vadim.hw7.service.application.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final IOService ioService;

    @Override
    public void showAllBook() {
        List<Book> bookList = (List<Book>) bookRepository.findAll();
        for (Book index : bookList) {
            ioService.out(messageBook(index));
        }
    }

    @Override
    public void deleteAllComment() {
        bookRepository.deleteAll();
    }

    private String messageBook(Book book) {
        String bookOut = "";
        bookOut = book.getId() + " " + book.getTitle() + " " +
                book.getPrice() + " " + book.getAuthors().getName() + " " + book.getGenre().getName() + "\n ";

        for (Comment index : book.getListReview()) {
            bookOut += index.getReview() + "\n ";
        }
        return bookOut;
    }
}
