package by.vadim.hw5.service.comment.impl;

import by.vadim.hw5.models.Comment;
import by.vadim.hw5.repositories.comment.CommentRepository;
import by.vadim.hw5.service.api.IOService;
import by.vadim.hw5.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
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
        ioService.out("Enter comment to insert");
        String commentToInsert = ioService.readString();
        Comment comment = new Comment();
        comment.setComment(commentToInsert);
        commentRepository.save(comment);
    }


    private String messageComment(Comment comment){
        String outComments = "";
        return outComments + comment.getId() + " " + comment.getComment();
    }
}
