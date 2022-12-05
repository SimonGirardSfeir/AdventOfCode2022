package org.example.day5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public record StackCratesInventory(List<Deque<Character>> stackCrates) {
    public static StackCratesInventory of(List<String> givenLines) {
        List<Deque<Character>> stackCratesToAdd = new ArrayList<>();
        int biggestStackSize = givenLines.size();
        int numberOfStacks = (givenLines.get(biggestStackSize -1).length() + 1)/4;

        populateStackListWithRightNumberOfEmptyStacks(stackCratesToAdd, numberOfStacks);

        fillStacksOfStackList(givenLines, stackCratesToAdd, biggestStackSize);

        return new StackCratesInventory(stackCratesToAdd);
    }
    private static void fillStacksOfStackList(List<String> givenLines, List<Deque<Character>> stackCratesToAdd, int biggestStackSize) {
        for(int i = biggestStackSize -1; i >= 0; i--) {
            String line = givenLines.get(i);
            int max = (line.length() + 1)/4;
            for(int j = 0; j < max; j++) {
                String input = line.substring(j*4, j*4+3);
                if(!input.isBlank()) {
                    Character character = input.charAt(1);
                    Deque<Character> stack = stackCratesToAdd.get(j);
                    stack.push(character);
                }
            }
        }
    }
    private static void populateStackListWithRightNumberOfEmptyStacks(List<Deque<Character>> stackCratesToAdd, int numberOfStacks) {
        int k = 0;
        while(k < numberOfStacks) {
            Deque<Character> stack = new ArrayDeque<>();
            stackCratesToAdd.add(stack);
            k++;
        }
    }
}
