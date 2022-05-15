package by.vadim.hw6.service.application.comment.impl;

import by.vadim.hw6.models.Book;
import by.vadim.hw6.models.Comment;
import by.vadim.hw6.repositories.BookRepositories;
import by.vadim.hw6.repositories.CommentRepositories;
import by.vadim.hw6.service.api.IOService;
import by.vadim.hw6.service.application.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepositories commentRepositories;
    private final BookRepositories bookRepositories;
    private final IOService ioService;

    @Override
    public void showCommentById() {
        ioService.out("Enter id comment to find");
        long idComments = Long.parseLong(ioService.readString());
        Optional<Comment> comment = commentRepositories.findById(idComments);
        ioService.out(messageComment(comment.orElseThrow()));
    }

    @Override
    public void addNewCommentToBook() {
        ioService.out("Enter title book to insert");
        String bookToInsertNewComment = ioService.readString();
        Book bookSearch = bookRepositories.findByTitle(bookToInsertNewComment);

        if (bookSearch == null) {
            ioService.out("This book not exists");
            return;
        }
        ioService.out("Enter comment to insert");
        String commentToInsert = ioService.readString();

        Comment comment = new Comment();
        comment.setComment(commentToInsert);
        comment.setBook(bookSearch);

        commentRepositories.save(comment);
    }

    @Override
    public void showAllCommentsByBook() {
        ioService.out("Enter id book to show all comments");
        long idBookToShowAllComments = Long.parseLong(ioService.readString());
        List<Comment> listSearchComments = commentRepositories.findCommentByBook_Id(idBookToShowAllComments);

        if (listSearchComments.isEmpty()) {
            ioService.out("List of comments is empty");
            return;
        }

        for (Comment index : listSearchComments) {
            ioService.out(messageComment(index));
        }
    }

    @Override
    public void deleteCommentById() {
        ioService.out("Enter id comments to delete");
        long deleteId = Long.parseLong(ioService.readString());
        commentRepositories.deleteById(deleteId);
    }

    private String messageComment(Comment comment) {
        String outComments = "";
        return outComments + comment.getId() + " " + comment.getComment();
    }
}
