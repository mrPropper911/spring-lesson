package task_leetcode_2244;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MinRoundsToCompleteAllTaskTest {

    @Test
    void minimumRounds() {

        assertAll(
                () -> assertThat(MinRoundsToCompleteAllTask.minimumRounds(new int[]{5,5,5,5}))
                        .isEqualTo(2),
                () -> assertThat(MinRoundsToCompleteAllTask.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}))
                        .isEqualTo(4),
                () -> assertThat(MinRoundsToCompleteAllTask.minimumRounds(new int[]{2 ,3 ,3}))
                        .isEqualTo(-1)
        );
    }
}