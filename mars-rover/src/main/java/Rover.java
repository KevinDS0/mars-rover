import java.util.Objects;

import static java.util.Objects.requireNonNull;

public final class Rover {

    private final Position position;
    private final Direction facingDirection;

    private Rover(Position position, Direction facingDirection) {
        this.position = requireNonNull(position);
        this.facingDirection = requireNonNull(facingDirection);
    }

    public static Rover from(Position position, Direction facingDirection) {
        return new Rover(position, facingDirection);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position) && facingDirection == rover.facingDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, facingDirection);
    }
}
