package org.example.day8;

import java.util.List;

public class ForestResolver {
    private ForestResolver() {
    }

    public static Forest getForestFromLines(List<String> lines) {
        return Forest.of(lines);
    }
}
