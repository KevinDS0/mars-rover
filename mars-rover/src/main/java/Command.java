import static java.util.Objects.requireNonNull;

public final class Command {

    private final CommandType type;

    private Command(CommandType type) {
        this.type = requireNonNull(type);
    }

    public static Command from(CommandType type) {
        return new Command(type);
    }

    public CommandType getType() {
        return type;
    }
}
