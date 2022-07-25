import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RoverShould {

    @Test
    void fail_to_initialize_from_null_position() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rover.from(null));
    }

    void initialize_from_defined_position() {

        var rover = Rover.from(Position.from(0,0));

        assertThat(rover).isEqualTo(aValidRoverWithPosition(0,0));
    }

    private static Rover aValidRoverWithPosition(int latitude, int longitude) {
        return Rover.from(aValidPosition(latitude, longitude));
    }

    private static Position aValidPosition(int latitude, int longitude) {
        return Position.from(latitude, longitude);
    }
}
