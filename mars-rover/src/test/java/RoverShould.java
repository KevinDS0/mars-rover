import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class RoverShould {

    private static final Position STARTING_POSITION = aValidPosition(0, 0);
    private static final Set<Obstacle> OBSTACLES = Set.of(Obstacle.from(Position.from(1, 1)), Obstacle.from(Position.from(-2, 0)));
    private Grid grid;

    @BeforeEach
    void before() {
        this.grid = Grid.aGrid(OBSTACLES);
    }

    @Test
    void initialize_with_default_position_and_direction() {
        var rover = Rover.from();
        assertThat(rover.getPosition()).isEqualTo(STARTING_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void move_to_0_1_when_receiving_move_forward_command_and_facing_north() {
        var rover = Rover.from();
        rover.receive(CommandType.MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(aValidPosition(0, 1));
    }

    @Test
    void move_to_1_0_when_receiving_move_forward_command_and_facing_east() {
        var rover = Rover.from();

        rover.receive(CommandType.TURN_RIGHT, grid);
        rover.receive(CommandType.MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(aValidPosition(1, 0));
    }

    @Test
    void move_to_minus_1_0_when_receiving_move_forward_command_and_facing_west() {
        var rover = Rover.from();

        rover.receive(CommandType.TURN_LEFT, grid);
        rover.receive(CommandType.MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(aValidPosition(-1, 0));
    }

    @Test
    void move_to_0_minus_1_when_receiving_move_forward_command_and_facing_south() {
        var rover = Rover.from();

        rover.receive(CommandType.TURN_RIGHT, grid);
        rover.receive(CommandType.TURN_RIGHT, grid);
        rover.receive(CommandType.MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(aValidPosition(0, -1));
    }

    @Test
    void turn_west_when_receiving_turn_left_command_and_facing_north() {
        var rover = Rover.from();

        rover.receive(CommandType.TURN_LEFT, grid);

        assertThat(rover.getPosition()).isEqualTo(STARTING_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void turn_east_when_receiving_turn_right_command_and_facing_north() {
        var rover = Rover.from();

        rover.receive(CommandType.TURN_RIGHT, grid);

        assertThat(rover.getPosition()).isEqualTo(STARTING_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void move_backwards_when_receiving_move_backwards_command_and_facing_north() {
        var rover = Rover.from();

        rover.receive(CommandType.MOVE_BACKWARDS, grid);

        assertThat(rover.getPosition()).isEqualTo(aValidPosition(0, -1));
    }

    @Test
    void move_to_opposite_site_when_reaching_east_edge() {
        var rover = Rover.from(5, 1, Direction.EAST);
        rover.receive(CommandType.MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(aValidPosition(-4, 1));
    }

    @Test
    void do_not_move_when_obstacle_is_on_the_way_moving_forward() {
        var rover = Rover.from(0, 1, Direction.EAST);
        rover.receive(CommandType.MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(aValidPosition(0, 1));
    }

    private static Position aValidPosition(Integer x, Integer y) {
        return Position.from(x, y);
    }
}
