package yandex_training_2_0.homework_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class DateExTest {

    @Test
    void mainLogic() {
        assertThat(DateEx.mainLogic(1, 2, 2023)).isEqualTo(0);
        assertThat(DateEx.mainLogic(2, 29, 2008)).isEqualTo(1);
        assertThat(DateEx.mainLogic(31, 12, 2008)).isEqualTo(1);
        assertThat(DateEx.mainLogic(1, 12, 2008)).isEqualTo(0);
        assertThat(DateEx.mainLogic(1, 13, 2008)).isEqualTo(1);
        assertThat(DateEx.mainLogic(12, 13, 2008)).isEqualTo(1);
        assertThat(DateEx.mainLogic(13, 12, 2002)).isEqualTo(1);
        assertThat(DateEx.mainLogic(31, 12, 2002)).isEqualTo(1);
        assertThat(DateEx.mainLogic(2, 2, 2002)).isEqualTo(1);


    }
}