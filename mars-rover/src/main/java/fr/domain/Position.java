package fr.domain;

import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public final class Position {

    private final Integer x;
    private final Integer y;

    private Position(Integer x, Integer y) {
        if (x < 1 || y < 1) {
            throw new IllegalArgumentException(format("Invalid position {x=%s, y=%s} must be > {1, 1}", x, y));
        }
        this.x = requireNonNull(x);
        this.y = requireNonNull(y);
    }

    public static Position from(Integer x, Integer y) {
        return new Position(x, y);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) && Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
