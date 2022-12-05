package org.example.day5;

import java.util.Deque;
import java.util.List;

public interface InstructionPerformer {
    StackCratesInventory applyInstruction(StackCratesInventory stackCratesInventory, Instruction instruction);

    default String applyInstructions(StackCratesInventory stackCratesInventory, List<Instruction> instructions) {
        for(Instruction instruction : instructions) {
            stackCratesInventory = applyInstruction(stackCratesInventory, instruction);
        }

        StringBuilder messageBuilder = new StringBuilder();
        for(Deque<Character> stack : stackCratesInventory.stackCrates()) {
            messageBuilder.append(stack.peek());
        }
        return messageBuilder.toString();
    }
}
