package org.example.day9;

import org.example.common.Position;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    RIGHT("R", 1, 0), LEFT("L", -1, 0), DOWN("D", 0, -1),
    UP("U", 0, 1), UPLEFT("UL", -1, 1), UPRIGHT("UR", 1, 1),
    DOWNLEFT("DL", -1, -1), DOWNRIGHT("DR", 1, -1);

    private static final Map<String, Direction> BY_LABEL = new HashMap<>();
    private static final Map<Position, Direction> BY_DELTA = new HashMap<>();

    static {
        for(Direction direction : values()) {
            BY_LABEL.put(direction.label, direction);
            BY_DELTA.put(new Position(direction.dx, direction.dy), direction);
        }
    }

    private final String label;
    private final int dx;
    private final int dy;

    Direction(String label, int dx, int dy) {
        this.label = label;
        this.dx = dx;
        this.dy = dy;
    }

    static Direction valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
    static Direction valueOfDelta(int dx, int dy) {
        return BY_DELTA.get(new Position(dx, dy));
    }

    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
}
