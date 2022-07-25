public final class Rover {

    private static final Position STARTING_POSITION = Position.from(0, 0);
    private static final Direction STARTING_DIRECTION = Direction.NORTH;
    private final Position position;
    private final Direction facingDirection;

    private Rover() {
        this.position = STARTING_POSITION;
        this.facingDirection = STARTING_DIRECTION;
    }

    public static Rover from() {
        return new Rover();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }
}
