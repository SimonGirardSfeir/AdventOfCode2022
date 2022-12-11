package org.example.day4;

import java.util.Arrays;

public record Section(int start, int end) {
    public static Section of(String line) {
        Integer[] splitLimits = Arrays.stream(line.split("-")).map(Integer::valueOf).toArray(Integer[]::new);
        return new Section(splitLimits[0],splitLimits[1]);
    }
}
