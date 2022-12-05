package org.example.day5;

import java.util.ArrayDeque;
import java.util.Deque;

public class InstructionPerformerClassicOrder implements InstructionPerformer {
    @Override
    public StackCratesInventory applyInstruction(StackCratesInventory stackCratesInventory, Instruction instruction) {
        Deque<Character> sourceStack = stackCratesInventory.stackCrates().get(instruction.sourceStack()-1);
        Deque<Character> targetStack = stackCratesInventory.stackCrates().get(instruction.targetStack()-1);
        Deque<Character> charToAdd = new ArrayDeque<>();
        int index = instruction.numberOfElementToMove();
        while(index > 0) {
            Character character = sourceStack.pop();
            charToAdd.push(character);
            index--;
        }

        while(!charToAdd.isEmpty()) {
            targetStack.push(charToAdd.pop());
        }
        return stackCratesInventory;
    }
}
