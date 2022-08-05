package fr.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static fr.domain.Command.*;
import static fr.domain.Direction.*;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RoverTest {

    private static final Position DEFAULT_POSITION = positionAt(1, 1);
    private static final Set<Obstacle> OBSTACLES = Set.of(Obstacle.from(positionAt(2, 1)), Obstacle.from(positionAt(4, 4)));

    private final Grid grid = Grid.with(OBSTACLES);

    @Test
    void initialize_with_default_position_and_direction() {
        var rover = Rover.byDefault();

        assertThat(rover.getPosition()).isEqualTo(DEFAULT_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(NORTH);
    }

    @Test
    void increment_y_when_receiving_move_forward_command_and_facing_north() {
        var rover = Rover.byDefault();

        rover.receive(MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(positionAt(1, 2));
    }

    @Test
    void increment_x_when_receiving_move_forward_command_and_facing_east() {
        var rover = Rover.from(3, 2, EAST);

        rover.receive(MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(positionAt(4, 2));
    }

    @Test
    void turn_west_when_receiving_turn_left_command_and_facing_north() {
        var rover = Rover.byDefault();

        rover.receive(TURN_LEFT, grid);

        assertThat(rover.getPosition()).isEqualTo(DEFAULT_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(WEST);
    }

    @Test
    void turn_east_when_receiving_turn_right_command_and_facing_north() {
        var rover = Rover.byDefault();

        rover.receive(TURN_RIGHT, grid);

        assertThat(rover.getPosition()).isEqualTo(DEFAULT_POSITION);
        assertThat(rover.getFacingDirection()).isEqualTo(EAST);
    }

    @Test
    void move_backwards_when_receiving_move_backwards_command_and_facing_north() {
        var rover = Rover.from(3, 2, NORTH);

        rover.receive(MOVE_BACKWARDS, grid);

        assertThat(rover.getPosition()).isEqualTo(positionAt(3, 1));
    }

    @Test
    void return_to_starting_x_when_reaching_bound() {
        var rover = Rover.from(5, 1, EAST);

        rover.receive(MOVE_FORWARD, grid);

        assertThat(rover.getPosition()).isEqualTo(positionAt(1, 1));
    }

    @Test
    void do_not_move_when_obstacle_is_on_the_way_moving_forward() {
        var rover = Rover.from(1, 1, EAST);

        assertThatExceptionOfType(ObstacleFoundException.class)
                .isThrownBy(() -> rover.receive(MOVE_FORWARD, grid))
                .withMessage(format("Obstacle found at position : %s", positionAt(2, 1)));
        assertThat(rover.getPosition()).isEqualTo(positionAt(1, 1));
    }

    private static Position positionAt(Integer x, Integer y) {
        return Position.from(x, y);
    }
}
