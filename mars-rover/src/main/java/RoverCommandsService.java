import java.util.Arrays;
import java.util.stream.Stream;

public class RoverCommandsService implements RoverCommands {
    private final Rover rover;

    public RoverCommandsService(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void send(char[] commandArray) {
        Arrays.stream(String.valueOf(commandArray).split(""))
                .map(CommandType::from)
                .forEachOrdered(rover::receive);

    }

}
