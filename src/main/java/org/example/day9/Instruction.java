package org.example.day9;

public record Instruction(Direction direction, int stepsNumber) {
    public static Instruction of(String line) {
        String[] splitedLine = line.split(" ");
        return new Instruction(Direction.valueOfLabel(splitedLine[0]), Integer.parseInt(splitedLine[1]));
    }
}
