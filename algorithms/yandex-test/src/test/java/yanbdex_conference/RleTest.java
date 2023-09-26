package yanbdex_conference;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RleTest {

    @Test
    void testAnswer() {

        assertAll(
                () -> assertThat(Rle.parseStringToRange("A15BA5")).isEqualTo(21),
                () -> assertThat(Rle.parseStringToRange("ABCDR")).isEqualTo(5),
                () -> assertThat(Rle.parseStringToRange("Z123XY")).isEqualTo(125)
        );

    }
}