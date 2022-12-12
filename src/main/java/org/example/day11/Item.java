package org.example.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Item(long worryLevel) {
    public static List<Item> of(String line) {
        String interestingPartOfLine = line.substring(18);
        return Arrays.stream(interestingPartOfLine.split(", "))
                .map(itemAsString -> new Item(Long.parseLong(itemAsString)))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
