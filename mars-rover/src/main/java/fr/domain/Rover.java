package fr.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Rover {

    private static final Position DEFAULT_POSITION = Position.from(1, 1);
    private static final Direction DEFAULT_DIRECTION = Direction.NORTH;

    private Position position;
    private Direction facingDirection;

    private Rover(Position position, Direction direction) {
        this.position = position;
        this.facingDirection = direction;
    }

    public static Rover byDefault() {
        return new Rover(DEFAULT_POSITION, DEFAULT_DIRECTION);
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

    public void receive(Command command, Grid grid) {
        switch (command) {
            case MOVE_FORWARD, MOVE_BACKWARDS -> move(command, grid);
            case TURN_RIGHT, TURN_LEFT -> turn(command);
        }
    }

    private boolean isObstructingObstaclePresent(Position position, Set<Obstacle> obstacles) {
        var obstaclePositions = obstacles.stream().map(Obstacle::getPosition).collect(Collectors.toUnmodifiableSet());
        return obstaclePositions.contains(position);
    }

    private void move(Command type, Grid grid) {
        int newX = position.getX();
        int newY = position.getY();

        if (type == Command.MOVE_FORWARD) {
            newX = position.getX() + facingDirection.getX();
            newY = position.getY() + facingDirection.getY();
        }
        if (type == Command.MOVE_BACKWARDS) {
            newX = position.getX() - facingDirection.getX();
            newY = position.getY() - facingDirection.getY();
        }

        var newPosition = handleRoverOutsideOfBounds(newX, newY, grid.getGridSize());
        if (!isObstructingObstaclePresent(newPosition, grid.getObstacles())) {
            position = newPosition;
        } else {
            throw new ObstacleFoundException(newPosition);
        }
    }

    private void turn(Command type) {
        facingDirection = facingDirection.nextDirectionFor(type);
    }

    private Position handleRoverOutsideOfBounds(Integer x, Integer y, Integer gridBoundsPoint) {

        if (x > gridBoundsPoint) {
            x = DEFAULT_POSITION.getX();
        }
        if (x < DEFAULT_POSITION.getX()) {
            x = gridBoundsPoint;
        }

        if (y > gridBoundsPoint) {
            y = DEFAULT_POSITION.getY();
        }
        if (y < DEFAULT_POSITION.getY()) {
            y = gridBoundsPoint;
        }
        return Position.from(x, y);
    }
}
