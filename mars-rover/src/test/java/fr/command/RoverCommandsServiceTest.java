package fr.command;

import fr.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RoverCommandsServiceTest {

    private static final Set<Obstacle> OBSTACLES = Set.of(Obstacle.from(Position.from(2, 2)), Obstacle.from(Position.from(4, 4)));

    private final Rover rover = Rover.byDefault();
    private final Grid grid = Grid.with(OBSTACLES);
    private final RoverCommands roverCommands = new RoverCommandsService(rover, grid);

    @Test
    void send_move_forward_and_turn_left_command() {
        char[] command = {'F', 'L'};

        roverCommands.send(command);

        assertThat(rover.getPosition().getX()).isEqualTo(1);
        assertThat(rover.getPosition().getY()).isEqualTo(2);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void send_complex_command() {
        char[] command = {'F', 'L', 'L', 'F', 'R', 'F'};

        roverCommands.send(command);

        assertThat(rover.getPosition().getX()).isEqualTo(5);
        assertThat(rover.getPosition().getY()).isEqualTo(1);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.WEST);
    }


    @Test
    void send_command_that_move_rover_to_x_grid_edge() {
        char[] command = {'R', 'F', 'F', 'F', 'F', 'F', 'F'};

        roverCommands.send(command);

        assertThat(rover.getPosition().getX()).isEqualTo(2);
        assertThat(rover.getPosition().getY()).isEqualTo(1);
    }

    @Test
    void stop_receiving_commands_when_obstacle_is_found() {
        char[] command = {'F', 'R', 'F', 'F'};

        roverCommands.send(command);

        assertThat(rover.getPosition().getX()).isEqualTo(1);
        assertThat(rover.getPosition().getY()).isEqualTo(2);
    }
}