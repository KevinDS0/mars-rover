import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoverShould {
    @Test
    void initialize_with_default_position_and_direction() {

        var rover = Rover.from();

        assertThat(rover.getPosition()).isEqualTo(aValidPosition());
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.NORTH);
    }

    private static Position aValidPosition() {
        return Position.from(0, 0);
    }
}
