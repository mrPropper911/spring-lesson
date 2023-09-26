package yandex_training_2_0.packA.homework_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class HardEquationTest {

    @Test
    void mainLogic() {
        assertThat(HardEquation.mainLogic(1, 1, 2, 2)).isEqualTo("NO");
        assertThat(HardEquation.mainLogic(2, -4, 7, 1)).isEqualTo("2");
        assertThat(HardEquation.mainLogic(35, 14, 11, -3)).isEqualTo("NO");
    }
}