package org.example.day4;

import java.util.Arrays;

public record Section(int start, int end) {
    public static Section of(String line) {
        Integer[] splitedLimits = Arrays.stream(line.split("-")).map(Integer::valueOf).toArray(Integer[]::new);
        return new Section(splitedLimits[0],splitedLimits[1]);
    }
}
