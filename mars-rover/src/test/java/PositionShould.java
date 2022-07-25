import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionShould {

    @Test
    void initialize_from_valid_latitude_and_longitude() {
        var position = Position.from(0, 0);

        assertThat(position).isEqualTo(aValidPosition(0, 0));
    }

    @Test
    void initialize_from_positive_latitude_and_longitude() {
        var position = Position.from(1, 1);

        assertThat(position).isEqualTo(aValidPosition(1, 1));
    }

    @Test
    void initialize_from_negative_latitude_and_longitude() {
        var position = Position.from(-1, -1);

        assertThat(position).isEqualTo(aValidPosition(-1, -1));
    }

    private static Position aValidPosition(int latitude, int longitude) {
        return Position.from(latitude, longitude);
    }
}
