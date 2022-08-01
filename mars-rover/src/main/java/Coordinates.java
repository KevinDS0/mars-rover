import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class Coordinates {

    private final Integer latitude;
    private final Integer longitude;

    private Coordinates(Integer latitude, Integer longitude) {
        this.latitude = requireNonNull(latitude);
        this.longitude = requireNonNull(longitude);
    }

    public static Coordinates from(Integer latitude, Integer longitude) {
        return new Coordinates(latitude, longitude);
    }

    public Integer getLatitude() {
        return latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return Objects.equals(latitude, coordinates.latitude) && Objects.equals(longitude, coordinates.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }

    @Override
    public String toString() {
        return "{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
