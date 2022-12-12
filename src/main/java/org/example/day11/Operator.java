package org.example.day11;

import java.util.HashMap;
import java.util.Map;

public enum Operator {
    ADDITION("+"), MULTIPLICATION("*"), SQUARE("^");
    private static final Map<String, Operator> BY_LABEL = new HashMap<>();

    static {
        for(Operator operator : values())
            BY_LABEL.put(operator.label, operator);
    }

    private final String label;

    Operator(String label) {
        this.label = label;
    }

    public static Operator valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
