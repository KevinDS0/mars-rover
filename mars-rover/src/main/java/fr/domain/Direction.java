package fr.domain;

import static fr.domain.Command.TURN_LEFT;
import static fr.domain.Command.TURN_RIGHT;

public enum Direction {
    NORTH(0, 1),
    WEST(-1, 0),
    SOUTH(0, -1),
    EAST(1, 0);

    private final Integer x;
    private final Integer y;

    Direction(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction nextDirectionFor(Command command) {
        var nextIndex = 0;
        if (command == TURN_LEFT) {
            nextIndex = ordinal() + 1;
        }
        if (command == TURN_RIGHT) {
            nextIndex = ordinal() - 1;
        }

        if (nextIndex % Direction.values().length == 0) {
            nextIndex = 0;
        }
        if (nextIndex % Direction.values().length < 0) {
            nextIndex = Direction.values().length - 1;
        }
        return Direction.values()[nextIndex];
    }
}
