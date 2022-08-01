import java.util.Arrays;

public class RoverCommandsService implements RoverCommands {
    private final Rover rover;

    public RoverCommandsService(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void send(String command) {
        Arrays.stream(command.split(""))
                .map(CommandType::from)
                .forEachOrdered(rover::receive);
    }
}
