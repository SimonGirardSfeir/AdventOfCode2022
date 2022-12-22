package org.example.day10;

import java.util.List;

import static org.example.day10.InstructionType.ADDX;
import static org.example.day10.InstructionType.NOOP;

public final class CPUResolver {
    private CPUResolver(){
    }

    public static List<CPUInstruction> getCPUInstructionsFromLines(List<String> lines) {
        return lines.stream().map(CPUResolver::getCPUInstructionFromLine).toList();
    }

    public static CPUInstruction getCPUInstructionFromLine(String line) {
        String[] splitLine = line.split(" ");
        if(splitLine.length == 1)
            return new CPUInstruction(NOOP, 0);
        else
            return new CPUInstruction(ADDX, Integer.parseInt(splitLine[1]));
    }
}
