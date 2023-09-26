package yandex_training_2_0.homework_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class DotAndTriangleTest {

    @Test
    void mainLogic() {
        assertThat(DotAndTriangle.mainLogic(4, new int[]{4, 4})).isEqualTo(2);
        assertThat(DotAndTriangle.mainLogic(5, new int[]{1, 1})).isEqualTo(0);
        assertThat(DotAndTriangle.mainLogic(3, new int[]{-1, -1})).isEqualTo(1);
        assertThat(DotAndTriangle.mainLogic(4, new int[]{2, 2})).isEqualTo(0);
    }
}