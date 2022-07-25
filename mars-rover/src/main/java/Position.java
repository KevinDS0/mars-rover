import java.util.Objects;

public final class Position {

    private final int latitude;
    private final int longitude;

    private Position(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static Position from(int latitude, int longitude) {
        return new Position(latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return latitude == position.latitude && longitude == position.longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
