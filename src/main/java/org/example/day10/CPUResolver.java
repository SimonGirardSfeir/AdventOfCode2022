package org.example.day10;

import java.util.List;

public class CPUResolver {
    private CPUResolver(){
    }

    public static List<CPUInstruction> getCPUInstructionFromLines(List<String> lines) {
        return lines.stream().map(CPUInstruction::of).toList();
    }
}
