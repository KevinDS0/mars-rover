import static java.lang.String.format;

public class Rover {

    private static final Coordinates STARTING_COORDINATES = Coordinates.from(0, 0);
    private static final Direction STARTING_DIRECTION = Direction.NORTH;
    private Coordinates coordinates;
    private Direction facingDirection;

    private Rover() {
        this.coordinates = STARTING_COORDINATES;
        this.facingDirection = STARTING_DIRECTION;
    }

    public static Rover from() {
        return new Rover();
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void receive(CommandType commandType) {
        if (commandType == CommandType.MOVE) {
            move();
        } else {
            turn(commandType);
        }
    }

    private void turn(CommandType type) {
        facingDirection = facingDirection.nextAt(type)
                .orElseThrow(() -> new IllegalStateException(format("Cannot find valid direction for rover when receiving command type : %s", type)));
    }

    private void move() {
        coordinates = Coordinates.from(coordinates.getLatitude() + facingDirection.getLatitude(),
                coordinates.getLongitude() + facingDirection.getLongitude());
    }
}
