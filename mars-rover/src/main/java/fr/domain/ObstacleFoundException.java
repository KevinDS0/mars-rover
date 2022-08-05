package fr.domain;

import static java.lang.String.format;

public class ObstacleFoundException extends RuntimeException {

    ObstacleFoundException(Position position) {super(format("Obstacle found at position : %s", position));}
}
