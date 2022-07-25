import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoverShould {

    @Test
    void fail_to_initialize_from_null_position() {

        assertThatNullPointerException()
                .isThrownBy(() -> Rover.from(null));
    }

    void initialize_from_defined_position() {

        var rover = Rover.from(Position.from(0,0));

        assertThat(rover).isEqualTo(aValidRoverWithPosition());
    }

    private static Rover aValidRoverWithPosition() {
        return Rover.from(aValidPosition());
    }

    private static Position aValidPosition() {
        return Position.from(0, 0);
    }
}
