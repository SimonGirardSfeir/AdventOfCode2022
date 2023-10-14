package org.example.day5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.common.PatternReference.INTEGER_REGEX;

public final class StackCratesResolver {

    private static final Pattern ENCLOSING_UPPERCASE_PATTERN = Pattern.compile("\\[\\p{IsLatin}]");
    private static final int CELL_WITH_SPACE_WIDTH_IN_FILE = 4;
    private StackCratesResolver() {

    }

    public static StackCratesInventory getStackCratesInventoryFromLines(List<String> lines) {
        List<String> lineToProcess = new ArrayList<>();

        int i = 0;
        String tempLine = lines.getFirst();
        while (tempLine.contains("[")) {
            lineToProcess.add(tempLine);
            i++;
            tempLine = lines.get(i);
        }
        return generateStackCratesInventory(lineToProcess);
    }
    public static StackCratesInventory generateStackCratesInventory(List<String> lines) {
        List<Deque<Character>> stackCratesToAdd = new ArrayList<>();
        int biggestStackSize = lines.size();
        long numberOfStacks = ENCLOSING_UPPERCASE_PATTERN.matcher(lines.get(biggestStackSize -1)).results().count();

        populateStackListWithRightNumberOfEmptyStacks(stackCratesToAdd, numberOfStacks);

        fillStacksOfStackList(lines, stackCratesToAdd, biggestStackSize);

        return new StackCratesInventory(stackCratesToAdd);
    }
    public static List<Instruction> getInstructionsFromLines(List<String> lines) {
        List<Instruction> instructions = new ArrayList<>();

        for(String line: lines) {
            if(line.contains("move")) {
                instructions.add(getInstructionFromLine(line));
            }
        }
        return instructions;
    }

    public static Instruction getInstructionFromLine(String line) {
        Matcher matcher = INTEGER_REGEX.matcher(line);
        List<Integer> values = new ArrayList<>();
        while(matcher.find()) {
            values.add(Integer.parseInt(matcher.group()));
        }

        return new Instruction(values.getFirst(),
                values.get(1),
                values.get(2));
    }
    private static void fillStacksOfStackList(List<String> givenLines, List<Deque<Character>> stackCratesToAdd,
                                              int biggestStackSize) {
        for(int i = biggestStackSize -1; i >= 0; i--) {
            String line = givenLines.get(i);
            int max = (line.length() + 1)/CELL_WITH_SPACE_WIDTH_IN_FILE;
            for(int j = 0; j < max; j++) {
                String input = line.substring(j*CELL_WITH_SPACE_WIDTH_IN_FILE, (j+1)*CELL_WITH_SPACE_WIDTH_IN_FILE -1);
                if(!input.isBlank()) {
                    Character character = input.charAt(1);
                    Deque<Character> stack = stackCratesToAdd.get(j);
                    stack.push(character);
                }
            }
        }
    }
    private static void populateStackListWithRightNumberOfEmptyStacks(List<Deque<Character>> stackCratesToAdd,
                                                                      long numberOfStacks) {
        int k = 0;
        while(k < numberOfStacks) {
            Deque<Character> stack = new ArrayDeque<>();
            stackCratesToAdd.add(stack);
            k++;
        }
    }
}
