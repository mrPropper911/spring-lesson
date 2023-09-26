package yandex_training_2_0.homework_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class CreatingPolindromTest {

    @Test
    void mainLogicTest(){
        assertThat(CreatingPolindrom.mainLogic("a")).isEqualTo(0);
        assertThat(CreatingPolindrom.mainLogic("ab")).isEqualTo(1);
        assertThat(CreatingPolindrom.mainLogic("cognitive")).isEqualTo(4);
    }


}