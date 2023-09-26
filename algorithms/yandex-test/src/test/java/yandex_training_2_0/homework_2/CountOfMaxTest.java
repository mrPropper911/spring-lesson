package yandex_training_2_0.homework_2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class CountOfMaxTest {

    @Test
    void mainLogic() {
        assertThat(CountOfMax.mainLogic(new ArrayList<Integer>() {{
            add(1);
            add(7);
            add(9);
            add(0);
        }})).isEqualTo(1);
        assertThat(CountOfMax.mainLogic(new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(3);
            add(1);
            add(0);
        }})).isEqualTo(1);
    }
}