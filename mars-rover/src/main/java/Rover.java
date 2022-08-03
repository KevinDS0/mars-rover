import java.util.Set;

import static java.lang.String.format;

public class Rover {

    private static final Position STARTING_POSITION = Position.from(0, 0);
    private static final Direction STARTING_DIRECTION = Direction.NORTH;
    private Position position;
    private Direction facingDirection;

    private Rover(Position position, Direction direction) {
        this.position = position;
        this.facingDirection = direction;
    }

    public static Rover from() {
        return new Rover(STARTING_POSITION, STARTING_DIRECTION);
    }

    public static Rover from(Integer x, Integer y, Direction direction) {
        return new Rover(Position.from(x, y), direction);
    }

    public Position getPosition() {
        return position;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void receive(CommandType commandType, Grid grid) {
        handleRoverPositionGoingOutsideOfGridEdge(grid.getGridSize());
        switch (commandType) {
            case MOVE_FORWARD:
            case MOVE_BACKWARDS:
                move(commandType, grid.getObstacles());
                break;
            case TURN_RIGHT:
            case TURN_LEFT:
                turn(commandType);
                break;
            default:
                break;
        }
    }

    private boolean isObstructingObstaclePresent(Position position, Set<Obstacle> obstacles) {
        return obstacles.stream()
                .map(Obstacle::getPosition)
                .anyMatch(obstaclePosition -> obstaclePosition.equals(position));
    }

    private void move(CommandType type, Set<Obstacle> obstacles) {
        int newX;
        int newY;
        if (type == CommandType.MOVE_FORWARD) {
            newX = position.getX() + facingDirection.getX();
            newY = position.getY() + facingDirection.getY();
        } else {
            newX = position.getX() - facingDirection.getX();
            newY = position.getY() - facingDirection.getY();
        }
        var newPosition = Position.from(newX, newY);
        if (!isObstructingObstaclePresent(newPosition, obstacles)) {
            position = newPosition;
        }
    }

    private void turn(CommandType type) {
        facingDirection = facingDirection.nextAt(type)
                .orElseThrow(() -> new IllegalStateException(format("Cannot find valid direction for rover when receiving command type : %s", type)));
    }

    private void handleRoverPositionGoingOutsideOfGridEdge(Integer gridSize) {
        var newX = position.getX() >= gridSize ? -position.getX() : position.getX();
        var newY = position.getY() >= gridSize ? -position.getY() : position.getY();
        position = Position.from(newX, newY);
    }
}
