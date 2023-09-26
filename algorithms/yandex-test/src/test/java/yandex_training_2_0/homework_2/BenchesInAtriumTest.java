package yandex_training_2_0.homework_2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BenchesInAtriumTest {

    @Test
    void mainLogic() {
        assertThat(BenchesInAtrium.mainLogic(5, 2, new int[]{0, 2}))
                .isEqualTo(new int[]{2});
        assertThat(BenchesInAtrium.mainLogic(13, 4, new int[]{1, 4, 8, 11}))
                .isEqualTo(new int[]{4, 8});
        assertThat(BenchesInAtrium.mainLogic(14, 6, new int[]{1, 6, 8, 11, 12, 13}))
                .isEqualTo(new int[]{6, 8});
//        assertThat(BenchesInAtrium.mainLogic(15, 7, new int[]{1, 6, 8, 9, 11, 12, 13}))
//                .isEqualTo(new int[]{9});
////        assertThat(BenchesInAtrium.mainLogic(140, 7, new int[]{1, 2, 3, 4, 12, 13}))
////                .isEqualTo(new int[]{4, 12});
//        assertThat(BenchesInAtrium.mainLogic(140, 7, new int[]{1, 2, 3, 4, 12, 139}))
//                .isEqualTo(new int[]{12, 139});
//        assertThat(BenchesInAtrium.mainLogic(3, 1, new int[]{2}))
//                .isEqualTo(new int[]{2});
//        assertThat(BenchesInAtrium.mainLogic(3, 2, new int[]{0, 2}))
//                .isEqualTo(new int[]{0, 2});
    }
}