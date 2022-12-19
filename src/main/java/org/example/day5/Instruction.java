package org.example.day5;

public record Instruction(int numberOfElementToMove, int sourceStack, int targetStack) {
    public static Instruction of(String line) {
        String[] splitLine = line.split(" ");

        return new Instruction(Integer.parseInt(splitLine[1]),
                Integer.parseInt(splitLine[3]),
                Integer.parseInt(splitLine[5]));
    }
}
