package by.vadim.hw5.service.comment.impl;

import by.vadim.hw5.models.Book;
import by.vadim.hw5.models.Comment;
import by.vadim.hw5.repositories.book.BookRepository;
import by.vadim.hw5.repositories.comment.CommentRepository;
import by.vadim.hw5.service.api.IOService;
import by.vadim.hw5.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final IOService ioService;

    @Override
    public void showCommentById() {
        ioService.out("Enter id comment to find");
        long idComments = Long.parseLong(ioService.readString());
        Optional<Comment> comment = commentRepository.findById(idComments);
        ioService.out(messageComment(comment.orElseThrow()));
    }

    @Override
    public void addNewCommentToBook() {
        Book book = new Book();
        ioService.out("Enter title book to insert");
        String bookToInsertNewComment = ioService.readString();
        List<Book> bookList = bookRepository.findByTitle(bookToInsertNewComment);

        if (bookList.size() == 0) {
            ioService.out("This book not exists");
            return;
        } else {
            book = bookList.get(0);
        }

        ioService.out("Enter comment to insert");
        String commentToInsert = ioService.readString();
        Comment comment = new Comment();
        comment.setComment(commentToInsert);
        comment.setBook(book);

        commentRepository.save(comment);
    }

    @Override
    public void showAllCommentsByBook() {
        ioService.out("Enter id book to show all comments");
        long idBookToShowAllComments = Long.parseLong(ioService.readString());
        List<Comment> listSearchComments = commentRepository.findAllCommentsByBookId(idBookToShowAllComments);

        if (listSearchComments.isEmpty()) {
            ioService.out("List of comments is empty");
            return;
        }

        for (Comment index : listSearchComments) {
            ioService.out(messageComment(index));
        }
    }

    private String messageComment(Comment comment) {
        String outComments = "";
        return outComments + comment.getId() + " " + comment.getComment();
    }
}
