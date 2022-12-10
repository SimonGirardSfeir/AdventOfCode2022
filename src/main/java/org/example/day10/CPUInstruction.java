package org.example.day10;

import static org.example.day10.InstructionType.ADDX;
import static org.example.day10.InstructionType.NOOP;

public record CPUInstruction(InstructionType instructionType, int value) {
    public static CPUInstruction of(String line) {
        String[] splitedLine = line.split(" ");
        if(splitedLine.length == 1)
            return new CPUInstruction(NOOP, 0);
        else
            return new CPUInstruction(ADDX, Integer.parseInt(splitedLine[1]));
    }
}
