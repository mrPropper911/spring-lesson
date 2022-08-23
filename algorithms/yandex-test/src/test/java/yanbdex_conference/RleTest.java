package yanbdex_conference;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.assertj.core.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RleTest {

    @Test
    void testAnswer() {
        Rle rle = new Rle();

        assertAll(
                () -> assertThat(rle.parseStringToRange("A15BA5")).isEqualTo(21),
                () -> assertThat(rle.parseStringToRange("ABCDR")).isEqualTo(5),
                () -> assertThat(rle.parseStringToRange("Z123XY")).isEqualTo(125)
        );



    }
}