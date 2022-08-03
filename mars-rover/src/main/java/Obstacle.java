
public class Obstacle {

    private final Position position;

    private Obstacle(Position position) {
        this.position = position;
    }

    public static Obstacle from(Position position) {
        return new Obstacle(position);
    }

    public Position getPosition() {
        return position;
    }
}
