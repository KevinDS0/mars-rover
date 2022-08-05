package fr.domain;

import java.util.Collections;
import java.util.Set;

public final class Grid {

    private static final Integer DEFAULT_GRID_SIZE = 5;

    private final Integer gridSize;
    private final Set<Obstacle> obstacles;

    private Grid(Set<Obstacle> obstacles) {
        this.gridSize = DEFAULT_GRID_SIZE;
        this.obstacles = obstacles;
    }

    public static Grid with(Set<Obstacle> obstacles) {
        return new Grid(obstacles);
    }

    public Integer getGridSize() {
        return gridSize;
    }

    public Set<Obstacle> getObstacles() {
        return Collections.unmodifiableSet(obstacles);
    }
}
