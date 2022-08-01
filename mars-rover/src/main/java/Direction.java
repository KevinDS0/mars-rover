import java.util.Optional;

public enum Direction {
    NORTH(0, 1),
    WEST(-1, 0),
    SOUTH(0, -1),
    EAST(1, 0);

    private final Integer latitude;
    private final Integer longitude;

    Direction(Integer latitude, Integer longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public Optional<Direction> nextAt(CommandType commandType) {
        var nextIndex = commandType == CommandType.TURN_LEFT ? ordinal() + 1 : ordinal() - 1;
        return Optional.of(nextIndex)
                .map(index -> index > Direction.values().length ? 0 : index)
                .map(index -> index < 0 ? Direction.values().length : index)
                .map(index -> Direction.values()[index]);
    }
}
