package org.example.day5;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InstructionPerformerClassicOrder implements InstructionPerformer {
    @Override
    public StackCratesInventory applyInstruction(StackCratesInventory stackCratesInventory, Instruction instruction) {
        Deque<Character> sourceStack = stackCratesInventory.stackCrates().get(instruction.sourceStack()-1);
        Deque<Character> targetStack = stackCratesInventory.stackCrates().get(instruction.targetStack()-1);
        List<Character> charToAdd = new ArrayList<>();
        int index = instruction.numberOfElementToMove();
        while(index > 0) {
            Character character = sourceStack.pop();
            charToAdd.add(character);
            index--;
        }

        for(int i = charToAdd.size() - 1; i >= 0; i--) {
            targetStack.push(charToAdd.get(i));
        }
        return stackCratesInventory;
    }
}
