import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoverShould {

    private Rover rover;

    @BeforeEach
    void before(){
        this.rover = Rover.from();
    }
    @Test
    void initialize_with_default_position_and_direction() {
        assertThat(rover.getCoordinates()).isEqualTo(aValidCoordinates(0, 0));
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void move_to_0_1_when_facing_starting_direction() {
        var command = Command.from("M");

        rover.receive(command);

        assertThat(rover.getCoordinates()).isEqualTo(aValidCoordinates(0, 1));
    }

    private static Coordinates aValidCoordinates(Integer latitude, Integer longitude) {
        return Coordinates.from(latitude, longitude);
    }
}
