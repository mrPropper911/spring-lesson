package by.vadim.hw5.service.shell;

import by.vadim.hw5.service.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@AllArgsConstructor
public class ApplicateionEventsComment {
    private final CommentService commentService;

    @ShellMethod(value = "show comment by id", key = {"shC", "show comment"})
    void showCommentsById() {
        commentService.showCommentById();
    }

    @ShellMethod(value = "add new comment to book", key = {"nC", "new comment"})
    void addNewCommentToBook() {
        commentService.addNewCommentToBook();
    }

    @ShellMethod(value = "show all comments from book", key = {"shbC", "show book comments"})
    void showAllCommentsFromBook() {
        commentService.showAllCommentsByBook();
    }
}
