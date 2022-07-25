import static java.util.Objects.requireNonNull;

public final class Command {

    private final String value;

    private Command(String value) {
        this.value = requireNonNull(value);
    }

    public static Command from(String value) {
        return new Command(value);
    }

    public String getValue() {
        return value;
    }
}
