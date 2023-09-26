package yandex_training_2_0.homework_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class CircleLineMetroTest {

    @Test
    void mainLogic() {
        assertThat(CircleLineMetro.mainLogic(100, 5, 6)).isEqualTo(0);
        assertThat(CircleLineMetro.mainLogic(10, 1, 9)).isEqualTo(1);
        assertThat(CircleLineMetro.mainLogic(11, 1, 9)).isEqualTo(2);
        assertThat(CircleLineMetro.mainLogic(100, 1, 50)).isEqualTo(48);
        assertThat(CircleLineMetro.mainLogic(100, 6, 5)).isEqualTo(0);
    }
}