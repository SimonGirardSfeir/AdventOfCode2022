package org.example.day9;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    RIGHT("R"), LEFT("L"), DOWN("D"), UP("U"), UPLEFT("UL"),
    UPRIGHT("UR"), DOWNLEFT("DL"), DOWNRIGHT("DR");

    private static final Map<String, Direction> BY_LABEL = new HashMap<>();

    static {
        for(Direction direction : values())
            BY_LABEL.put(direction.label, direction);
    }

    private final String label;

    Direction(String label) {
        this.label = label;
    }

    static Direction valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}
