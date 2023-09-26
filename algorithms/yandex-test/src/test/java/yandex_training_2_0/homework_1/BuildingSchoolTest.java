package yandex_training_2_0.homework_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BuildingSchoolTest {

    @Test
    void mainLogic() {
        assertThat(BuildingSchool.mainLogic(4, new String[]{"1", "2", "3", "4"})).isEqualTo("3");
        assertThat(BuildingSchool.mainLogic(3, new String[]{"-1", "0", "1"})).isEqualTo("0");
    }
}