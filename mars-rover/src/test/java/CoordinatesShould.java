import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CoordinatesShould {

    @Test
    void fail_to_initialize_from_null_latitude_and_longitude() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> Coordinates.from(null, null));
    }

    @Test
    void initialize_from_valid_latitude_and_longitude() {
        var coordinates = Coordinates.from(0, 0);

        assertThat(coordinates).isEqualTo(aValidCoordinates(0, 0));
    }

    @Test
    void initialize_from_positive_latitude_and_longitude() {
        var coordinates = Coordinates.from(1, 1);

        assertThat(coordinates).isEqualTo(aValidCoordinates(1, 1));
    }

    @Test
    void initialize_from_negative_latitude_and_longitude() {
        var coordinates = Coordinates.from(-1, -1);

        assertThat(coordinates).isEqualTo(aValidCoordinates(-1, -1));
    }

    private static Coordinates aValidCoordinates(Integer latitude, Integer longitude) {
        return Coordinates.from(latitude, longitude);
    }
}
