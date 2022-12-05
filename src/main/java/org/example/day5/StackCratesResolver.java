package org.example.day5;

import java.util.ArrayList;
import java.util.List;

public class StackCratesResolver {
    private StackCratesResolver() {

    }

    public static StackCratesInventory getStackCratesInventoryFromLines(List<String> lines) {
        List<String> lineToProcess = new ArrayList<>();

        int i = 0;
        String tempLine = lines.get(0);
        while (tempLine.contains("[")) {
            lineToProcess.add(tempLine);
            i++;
            tempLine = lines.get(i);
        }
        return StackCratesInventory.of(lineToProcess);
    }
    public static List<Instruction> getInstructionsFromLines(List<String> lines) {
        List<Instruction> instructions = new ArrayList<>();

        for(String line: lines) {
            if(line.contains("move")) {
                instructions.add(Instruction.of(line));
            }
        }
        return instructions;
    }
}
