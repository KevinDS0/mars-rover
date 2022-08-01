import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoverShould {

    private static final Coordinates STARTING_COORDINATES = aValidCoordinates(0, 0);
    private Rover rover;

    @BeforeEach
    void before(){
        this.rover = Rover.from();
    }
    @Test
    void initialize_with_default_position_and_direction() {
        assertThat(rover.getCoordinates()).isEqualTo(STARTING_COORDINATES);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void move_to_0_1_when_receiving_move_command_and_facing_starting_direction() {
        var command = Command.from(CommandType.MOVE);

        rover.receive(command);

        assertThat(rover.getCoordinates()).isEqualTo(aValidCoordinates(0, 1));
    }

    @Test
    void turn_west_when_receiving_turn_left_command_and_facing_north() {
        var command = Command.from(CommandType.TURN_LEFT);

        rover.receive(command);

        assertThat(rover.getCoordinates()).isEqualTo(STARTING_COORDINATES);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.WEST);
    }

    private static Coordinates aValidCoordinates(Integer latitude, Integer longitude) {
        return Coordinates.from(latitude, longitude);
    }
}
