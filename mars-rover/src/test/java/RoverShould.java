import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoverShould {

    @Test
    void fail_to_initialize_from_null_position() {

        assertThatNullPointerException()
                .isThrownBy(() -> Rover.from(null, Direction.SOUTH));
    }

    @Test
    void fail_to_initialize_from_null_facing_direction() {

        assertThatNullPointerException()
                .isThrownBy(() -> Rover.from(aValidPosition(), null));
    }

    @Test
    void initialize_from_defined_position_and_direction() {

        var rover = Rover.from(Position.from(0,0), Direction.SOUTH);

        assertThat(rover).isEqualTo(aValidRoverWithPosition());
    }

    private static Rover aValidRoverWithPosition() {
        return Rover.from(aValidPosition(), Direction.SOUTH);
    }

    private static Position aValidPosition() {
        return Position.from(0, 0);
    }
}
