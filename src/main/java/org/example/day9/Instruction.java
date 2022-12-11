package org.example.day9;

public record Instruction(Direction direction, int stepsNumber) {
    public static Instruction of(String line) {
        String[] splitLine = line.split(" ");
        return new Instruction(Direction.valueOfLabel(splitLine[0]), Integer.parseInt(splitLine[1]));
    }
}
