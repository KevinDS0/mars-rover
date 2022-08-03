import java.util.Optional;

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

    public Optional<Direction> nextAt(CommandType commandType) {
        var nextIndex = commandType == CommandType.TURN_LEFT ? ordinal() + 1 : ordinal() - 1;
        return Optional.of(nextIndex)
                .map(index -> index > Direction.values().length ? 0 : index)
                .map(index -> index < 0 ? (Direction.values().length - 1) : index)
                .map(index -> Direction.values()[index]);
    }
}
