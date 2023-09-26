package task_leetcode_39;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CombinationSumTest {

    @Test
    void combinationSum() {
        assertAll(
                () -> assertThat(CombinationSum.combinationSum(new int[]{2, 3, 5}, 8))
                        .hasSize(3),
                () -> assertThat(CombinationSum.combinationSum(new int[]{2}, 1))
                        .isEmpty(),
                () -> assertThat(CombinationSum.combinationSum(new int[]{2, 3, 6 ,7}, 7))
                        .hasSize(2)
                );

    }
}