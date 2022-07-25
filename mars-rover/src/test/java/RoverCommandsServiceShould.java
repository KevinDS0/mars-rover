import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.then;

class RoverCommandsServiceShould {

    private final Rover marsRover = Rover.from(Position.from(0,0), Direction.NORTH);
    private final RoverCommands roverCommands = new RoverCommandsService(marsRover);

    @Test
    void send_moving_command_to_rover() {
        var command = Command.from("M");

        roverCommands.send(command);

        then(marsRover).should(moveFrom(command));
    }
}
