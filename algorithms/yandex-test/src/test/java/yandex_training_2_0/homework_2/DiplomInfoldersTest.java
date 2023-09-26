package yandex_training_2_0.homework_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiplomInfoldersTest {

    @Test
    void mainLogic() {
        assertThat(DiplomInfolders.mainLogic(2, new int[]{1, 0, 2, 1})).isEqualTo(2);
        assertThat(DiplomInfolders.mainLogic(2, new int[]{2, 1})).isEqualTo(1);
    }
}