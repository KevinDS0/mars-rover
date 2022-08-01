public class RoverCommandsService implements RoverCommands {
    private final Rover rover;

    public RoverCommandsService() {
        this.rover = Rover.from();
    }

    @Override
    public void send(Command command) {
        rover.receive(command);
    }
}
