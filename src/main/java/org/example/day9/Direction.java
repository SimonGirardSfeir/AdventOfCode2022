package org.example.day9;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    RIGHT("R"), LEFT("L"), DOWN("D"), UP("U"), UPLEFT("UL"),
    UPRIGHT("UR"), DOWNLEFT("DL"), DOWNRIGHT("DR");

    private static final Map<String, Direction> BY_LABEL = new HashMap<>();

    static {
        for(Direction d : values())
            BY_LABEL.put(d.label, d);
    }

    private final String label;

    Direction(String label) {
        this.label = label;
    }

    static Direction valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}
