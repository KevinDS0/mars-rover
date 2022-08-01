import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class RoverCommandsServiceShould {

    private final Rover rover = mock(Rover.class);
    private final RoverCommands roverCommands = new RoverCommandsService(rover);

    @Test
    void send_move_turn_left_command() {
        var command = "ML";
        var inOrder = inOrder(rover);

        roverCommands.send(command);

        then(rover).should(times(1)).receive(CommandType.MOVE);
        then(rover).should(times(1)).receive(CommandType.TURN_LEFT);
        then(rover).should(never()).receive(CommandType.TURN_RIGHT);
        inOrder.verify(rover).receive(CommandType.MOVE);
        inOrder.verify(rover).receive(CommandType.TURN_LEFT);
    }

    @Test
    void send_complex_command() {
        var command = "MLLMRM";
        var inOrder = inOrder(rover);

        roverCommands.send(command);

        then(rover).should(times(3)).receive(CommandType.MOVE);
        then(rover).should(times(2)).receive(CommandType.TURN_LEFT);
        then(rover).should(times(1)).receive(CommandType.TURN_RIGHT);
        inOrder.verify(rover).receive(CommandType.MOVE);
        inOrder.verify(rover, times(2)).receive(CommandType.TURN_LEFT);
        inOrder.verify(rover).receive(CommandType.MOVE);
        inOrder.verify(rover).receive(CommandType.TURN_RIGHT);
        inOrder.verify(rover).receive(CommandType.MOVE);
    }
}