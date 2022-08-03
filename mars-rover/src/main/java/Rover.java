import static java.lang.String.format;

public class Rover {

    private static final Position STARTING_POSITION = Position.from(0, 0);
    private static final Direction STARTING_DIRECTION = Direction.NORTH;
    private Position position;
    private Direction facingDirection;

    private Rover() {
        this.position = STARTING_POSITION;
        this.facingDirection = STARTING_DIRECTION;
    }

    public static Rover from() {
        return new Rover();
    }

    public Position getCoordinates() {
        return position;
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
        var newX = position.getX() + facingDirection.getX();
        var newY = position.getY() + facingDirection.getY();
        position = Position.from(newX, newY);
    }
}
