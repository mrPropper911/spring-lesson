package yandex_training_2_0.packA.homework_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class ParallelogramTest {

    @Test
    void mainLogic() {
        assertThat(Parallelogram.mainLogic(new int[]{ 1, 1, 4, 2, 3, 0, 2, 3}))
                .isEqualTo("YES");
        assertThat(Parallelogram.mainLogic(new int[]{1, 1, 5,2, 2, 3, 3, 0}))
                .isEqualTo("NO");
        assertThat(Parallelogram.mainLogic(new int[]{0, 0, 5, 1, 6, 3, 1, 2}))
                .isEqualTo("YES");
    }
}