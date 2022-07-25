import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Rover {

    private final Position position;

    private Rover(Position position) {
        this.position = requireNonNull(position);
    }

    public static Rover from(Position position) {
        return new Rover(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(position, rover.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
