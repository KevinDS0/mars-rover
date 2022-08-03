import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoverShould {

    private static final Position STARTING_POSITION = aValidPosition(0, 0);
    private Rover rover;

    @BeforeEach
    void before() {
        this.rover = Rover.from();
    }

    @Test
    void initialize_with_default_position_and_direction() {
        assertThat(rover.getCoordinates()).isEqualTo(STARTING_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void move_to_0_1_when_receiving_move_command_and_facing_north() {

        rover.receive(CommandType.MOVE);

        assertThat(rover.getCoordinates()).isEqualTo(aValidPosition(0, 1));
    }

    @Test
    void move_to_1_0_when_receiving_move_command_and_facing_east() {
        rover.receive(CommandType.TURN_RIGHT);

        rover.receive(CommandType.MOVE);

        assertThat(rover.getCoordinates()).isEqualTo(aValidPosition(1, 0));
    }

    @Test
    void move_to_minus_1_0_when_receiving_move_command_and_facing_west() {
        rover.receive(CommandType.TURN_LEFT);

        rover.receive(CommandType.MOVE);

        assertThat(rover.getCoordinates()).isEqualTo(aValidPosition(-1, 0));
    }

    @Test
    void move_to_0_minus_1_when_receiving_move_command_and_facing_south() {
        rover.receive(CommandType.TURN_RIGHT);
        rover.receive(CommandType.TURN_RIGHT);

        rover.receive(CommandType.MOVE);

        assertThat(rover.getCoordinates()).isEqualTo(aValidPosition(0, -1));
    }

    @Test
    void turn_west_when_receiving_turn_left_command_and_facing_north() {
        rover.receive(CommandType.TURN_LEFT);

        assertThat(rover.getCoordinates()).isEqualTo(STARTING_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void turn_east_when_receiving_turn_right_command_and_facing_north() {
        rover.receive(CommandType.TURN_RIGHT);

        assertThat(rover.getCoordinates()).isEqualTo(STARTING_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.EAST);
    }

    private static Position aValidPosition(Integer x, Integer y) {
        return Position.from(x, y);
    }
}
