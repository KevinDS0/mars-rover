package fr.command;

import fr.domain.Command;
import fr.domain.Grid;
import fr.domain.ObstacleFoundException;
import fr.domain.Rover;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RoverCommandsService implements RoverCommands {

    private final Rover rover;
    private final Grid grid;

    public RoverCommandsService(Rover rover, Grid grid) {
        this.rover = rover;
        this.grid = grid;
    }

    @Override
    public void send(char[] commands) {
        var parsedCommands = parse(commands)
                .map(Command::from).collect(Collectors.toUnmodifiableList());
        for (Command command : parsedCommands) {
            try {
                rover.receive(command, grid);
            } catch (ObstacleFoundException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

    private static Stream<String> parse(char[] commands) {
        return Arrays.stream(String.valueOf(commands).split(""));
    }
}
