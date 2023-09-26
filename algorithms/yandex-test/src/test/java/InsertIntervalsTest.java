import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class InsertIntervalsTest {

    @Test
    void insert() {
        assertThat(InsertIntervals.insert(new int[][]{ new int[]{1,3}, new int[]{6,9}}, new int[]{2,5}))
                .isNotEmpty();
    }
}