package org.example.day3;

import java.util.List;

public record Rucksack(String firstCompartment, String secondCompartment) {
    public static Rucksack of(String line) {
        return new Rucksack(splitLineInTwoEqualPart(line)[0], splitLineInTwoEqualPart(line)[1]);
    }
    public Character getCommonItem() {
        return RucksackResolver.getCommonItemBetweenLines(List.of(firstCompartment, secondCompartment));
    }
    private static String[] splitLineInTwoEqualPart(String line) {
        return line.split("(?<=\\G.{" + line.length()/2 + "})");
    }
}
