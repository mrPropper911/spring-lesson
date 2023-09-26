package yandex_training_2_0.homework_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class HousesAndShopsTest {

    @Test
    void mainLogic() {
        assertThat(HousesAndShops.mainLogic(new int[]{2, 0, 1, 1, 0, 1, 0, 2, 1, 2})).isEqualTo(3);
    }

}