package org.example.day9;

import java.util.List;

public class GroudResolver {
    private GroudResolver(){
    }

    public static List<Instruction> getInstructionFromLines(List<String> lines){
        return lines.stream()
                .map(Instruction::of)
                .toList();
    }
}
