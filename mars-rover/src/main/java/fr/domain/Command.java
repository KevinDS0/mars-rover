package fr.domain;

import java.util.Arrays;

import static java.lang.String.format;

public enum Command {
    MOVE_FORWARD("F"),MOVE_BACKWARDS("B"), TURN_LEFT("L"), TURN_RIGHT("R");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command from(String value) {
        return Arrays.stream(Command.values())
                .filter(command -> command.value.equals(value))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(format("Value %s does not have corresponding Command value", value)));
    }
}
