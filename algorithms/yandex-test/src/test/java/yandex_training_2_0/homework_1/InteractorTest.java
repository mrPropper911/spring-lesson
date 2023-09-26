package yandex_training_2_0.homework_1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InteractorTest {

    @Test
    void mainLogic() {
        assertThat(Interactor.mainLogic(0, 0, 0)).isEqualTo(0);
        assertThat(Interactor.mainLogic(-1, 0, 1)).isEqualTo(3);
        assertThat(Interactor.mainLogic(42, 1, 6)).isEqualTo(6);
        assertThat(Interactor.mainLogic(44, 7, 4)).isEqualTo(1);
        assertThat(Interactor.mainLogic(-3, 2, 4)).isEqualTo(2);
    }
}