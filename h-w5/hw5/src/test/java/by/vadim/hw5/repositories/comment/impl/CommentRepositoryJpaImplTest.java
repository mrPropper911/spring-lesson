package by.vadim.hw5.repositories.comment.impl;

import by.vadim.hw5.models.Author;
import by.vadim.hw5.models.Book;
import by.vadim.hw5.models.Comment;
import by.vadim.hw5.models.Genre;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("Repository check for work with COMMENTS ")
@DataJpaTest
@Import(CommentRepositoryJpaImpl.class)
class CommentRepositoryJpaImplTest {
    private static final String COMMENTS_FOR_BOOK = "This is stupid book";
    private static final String TITLE_BOOK = "Спасибо что живой";
    private static final int PRICE_BOOK = 1;
    private static final String AUTHOR_NAME = "Высоцкий В.Ф.";
    private static final String GENRE_NAME = "Стихи";

    private static final long FIRST_COMMENT_ID = 1L;

    private static final String TESTING_COMMENT = "Testing comment";

    @Autowired
    CommentRepositoryJpaImpl repositoryJpa;

    @Autowired
    TestEntityManager testEntityManager;

    @DisplayName("should correct save all comments information")
    @Test
    void shouldSaveComment() {
        val title = TITLE_BOOK;
        val price = PRICE_BOOK;

        val author = new Author();
        author.setId(0L);
        author.setName(AUTHOR_NAME);

        val genre = new Genre();
        genre.setId(0L);
        genre.setName(GENRE_NAME);

        val comment = new Comment(0, COMMENTS_FOR_BOOK);
        val comments = Collections.singletonList(comment);
        val book = new Book(0, TITLE_BOOK, PRICE_BOOK, author, genre, comments);

        repositoryJpa.save(comment);
        assertThat(comment.getId()).isGreaterThan(0);

        val actualComment = testEntityManager.find(Comment.class, comment.getId());
        assertThat(actualComment).isNotNull()
                .matches(s -> !s.getComment().equals(""));
    }

    @DisplayName("should get information about comment by Id")
    @Test
    void shouldFindExpectedCommentById() {
        val actualComment = repositoryJpa.findById(FIRST_COMMENT_ID);
        val expectedBook = testEntityManager.find(Comment.class, FIRST_COMMENT_ID);
        assertThat(actualComment).isPresent().get()
                .usingRecursiveComparison().isEqualTo(expectedBook);
    }

    @DisplayName("should update comments by her id")
    @Test
    void shouldUpdateCommentById() {
        val firstComment = testEntityManager.find(Comment.class, FIRST_COMMENT_ID);
        String oldComment = firstComment.getComment();
        testEntityManager.detach(firstComment);

        repositoryJpa.updateCommentById(FIRST_COMMENT_ID, TESTING_COMMENT);
        val updateComment = testEntityManager.find(Book.class, FIRST_COMMENT_ID);

        assertThat(updateComment.getComments().get(0).getComment()).isNotEqualTo(oldComment).isEqualTo(TESTING_COMMENT);
    }


    @DisplayName("should delete comment by ID")
    @Test
    void shouldDeleteCommentByID() {
        val firstComment = testEntityManager.find(Comment.class,FIRST_COMMENT_ID);
        assertThat(firstComment).isNotNull();
        testEntityManager.detach(firstComment);

        repositoryJpa.deleteByID(FIRST_COMMENT_ID);
        val deleteComment = testEntityManager.find(Comment.class,FIRST_COMMENT_ID);

        assertThat(deleteComment).isNull();
    }
}