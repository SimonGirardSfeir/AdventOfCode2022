package org.example.day9;

import java.util.List;

public class GroundResolver {
    private GroundResolver(){
    }

    public static List<Instruction> getInstructionFromLines(List<String> lines){
        return lines.stream()
                .map(Instruction::of)
                .toList();
    }
}
