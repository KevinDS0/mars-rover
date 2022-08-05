package fr.domain;

import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.*;

class PositionTest {

    @Test
    void fail_to_initialize_from_null_x_and_y() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> Position.from(null, null));
    }

    @Test
    void initialize_from_valid_x_and_y() {
        var coordinates = Position.from(4, 2);

        assertThat(coordinates).isEqualTo(positionAt(4, 2));
    }

    @Test
    void initialize_from_positive_x_and_y() {
        var coordinates = Position.from(1, 1);

        assertThat(coordinates).isEqualTo(positionAt(1, 1));
    }

    @Test
    void fail_to_initialize_from_negative_x_and_y() {
        var x = -1;
        var y = -1;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Position.from(x, y))
                .withMessage(format("Invalid position {x=%s, y=%s} must be > {1, 1}", x, y));
    }

    private static Position positionAt(Integer x, Integer y) {
        return Position.from(x, y);
    }
}
