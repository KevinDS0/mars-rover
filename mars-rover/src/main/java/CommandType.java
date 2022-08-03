import java.util.Arrays;
import java.util.Optional;

import static java.lang.String.format;

public enum CommandType {
    MOVE("M"), TURN_LEFT("L"), TURN_RIGHT("R");

    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public static CommandType from(String value) {
        return Arrays.stream(CommandType.values())
                .filter(commandType -> commandType.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(format("Value %s does not have corresponding CommandType value", value)));
    }
}
