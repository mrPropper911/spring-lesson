package by.vadim.hw6.repositories;

import by.vadim.hw6.models.Comment;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Repository check for work with COMMENTS ")
@DataJpaTest
class CommentRepositoriesTest {
    private static final long FIRST_BOOK_ID = 1L;

    @Autowired
    private CommentRepositories commentRepositories;

    @Autowired
    private TestEntityManager testEntityManager;

    @DisplayName("should get information about comment by book_Id")
    @Test
    void shouldFindExpectedCommentByBookId() {
        val actualComment = commentRepositories.findCommentByBook_Id(FIRST_BOOK_ID);
        val expectedComment = testEntityManager.find(Comment.class, FIRST_BOOK_ID);
        assertThat(expectedComment).isEqualTo(actualComment.get(0));
    }
}