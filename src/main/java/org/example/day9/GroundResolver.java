package org.example.day9;

import java.util.List;

public final class GroundResolver {
    private GroundResolver(){
    }

    public static List<Instruction> getInstructionFromLines(List<String> lines){
        return lines.stream()
                .map(GroundResolver::getInstructionFromLine)
                .toList();
    }

    public static Instruction getInstructionFromLine(String line) {
        String[] splitLine = line.split(" ");
        return new Instruction(Direction.valueOfLabel(splitLine[0]), Integer.parseInt(splitLine[1]));
    }
}
