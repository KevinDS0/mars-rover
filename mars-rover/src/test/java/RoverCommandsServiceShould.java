import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RoverCommandsServiceShould {

    private static final Set<Obstacle> OBSTACLES = Set.of(Obstacle.from(Position.from(1,1)), Obstacle.from(Position.from(-2,0)));
    private final Rover rover = Rover.from();
    private final Grid grid = Grid.aGrid(OBSTACLES);
    private final RoverCommands roverCommands = new RoverCommandsService(rover, grid);

    @Test
    void send_move_forward_turn_left_command() {
        char[] command = {'F', 'L'};

        roverCommands.send(command);

        assertThat(rover.getPosition().getX()).isEqualTo(0);
        assertThat(rover.getPosition().getY()).isEqualTo(1);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.WEST);
    }

    @Test
    void send_complex_command() {
        char[] command = {'F', 'L', 'L', 'F', 'R', 'F'};

        roverCommands.send(command);

        assertThat(rover.getPosition().getX()).isEqualTo(-1);
        assertThat(rover.getPosition().getY()).isEqualTo(0);
        assertThat(rover.getFacingDirection()).isEqualTo(Direction.WEST);
    }


    @Test
    void send_command_that_move_rover_to_x_grid_edge() {
        char[] command = {'R', 'F', 'F', 'F', 'F', 'F', 'F'};

        roverCommands.send(command);
        assertThat(rover.getPosition().getX()).isEqualTo(-4);
        assertThat(rover.getPosition().getY()).isEqualTo(0);
    }
}