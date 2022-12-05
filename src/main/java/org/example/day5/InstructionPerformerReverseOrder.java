package org.example.day5;

import java.util.Deque;

public class InstructionPerformerReverseOrder implements InstructionPerformer {
    @Override
    public StackCratesInventory applyInstruction(StackCratesInventory stackCratesInventory, Instruction instruction) {
        Deque<Character> sourceStack = stackCratesInventory.stackCrates().get(instruction.sourceStack()-1);
        Deque<Character> targetStack = stackCratesInventory.stackCrates().get(instruction.targetStack()-1);
        int index = instruction.numberOfElementToMove();
        while(index > 0) {
            Character character = sourceStack.pop();
            targetStack.push(character);
            index--;
        }
        return stackCratesInventory;
    }
}
