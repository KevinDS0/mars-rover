import java.util.Arrays;

public class RoverCommandsService implements RoverCommands {
    private final Rover rover;

    private final Grid grid;

    public RoverCommandsService(Rover rover, Grid grid) {
        this.rover = rover;
        this.grid = grid;
    }

    @Override
    public void send(char[] commandArray) {
        Arrays.stream(String.valueOf(commandArray).split(""))
                .map(CommandType::from)
                .forEachOrdered(commandType -> rover.receive(commandType, grid));
    }
}
