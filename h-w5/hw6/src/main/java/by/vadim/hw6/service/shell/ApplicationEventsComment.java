package by.vadim.hw6.service.shell;

import by.vadim.hw6.service.application.comment.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@AllArgsConstructor
public class ApplicationEventsComment {
    private final CommentService commentService;

    @ShellMethod(value = "Add new comment to book", key = {"saveC", "save comment"})
    void addNewCommentToBook() {
        commentService.addNewCommentToBook();
    }

    @ShellMethod(value = "Show comment by id", key = {"showC", "show comment"})
    void showCommentsById() {
        commentService.showCommentById();
    }

    @ShellMethod(value = "Show all comments from book by id", key = {"showBookC", "show book comments"})
    void showAllCommentsFromBook() {
        commentService.showAllCommentsByBook();
    }

    @ShellMethod(value = "Delete comments by id", key = {"deleteC", "delete comments"})
    void deleteCommentsById() {
        commentService.deleteCommentById();
    }
}
