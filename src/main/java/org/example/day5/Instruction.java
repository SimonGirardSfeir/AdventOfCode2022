package org.example.day5;

public record Instruction(int numberOfElementToMove, int sourceStack, int targetStack) {
    public static Instruction of(String line) {
        String[] splitedLine = line.split(" ");

        return new Instruction(Integer.parseInt(splitedLine[1]), Integer.parseInt(splitedLine[3]), Integer.parseInt(splitedLine[5]));
    }
}
