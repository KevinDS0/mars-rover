import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositionShould {

    @Test
    void fail_to_initialize_from_null_x_and_y() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> Position.from(null, null));
    }

    @Test
    void initialize_from_valid_x_and_y() {
        var coordinates = Position.from(0, 0);

        assertThat(coordinates).isEqualTo(aValidCoordinates(0, 0));
    }

    @Test
    void initialize_from_positive_x_and_y() {
        var coordinates = Position.from(1, 1);

        assertThat(coordinates).isEqualTo(aValidCoordinates(1, 1));
    }

    @Test
    void initialize_from_negative_x_and_y() {
        var coordinates = Position.from(-1, -1);

        assertThat(coordinates).isEqualTo(aValidCoordinates(-1, -1));
    }

    private static Position aValidCoordinates(Integer x, Integer y) {
        return Position.from(x, y);
    }
}
