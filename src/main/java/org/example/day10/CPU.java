package org.example.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.example.day10.InstructionType.NOOP;

public final class CPU {

    private static final int IMAGE_WIDTH = 40;
    private static final String INITIAL_LINE = "........................................";
    private int register;
    private int currentCycle;

    private final Map<Integer, Integer> registerHistory;
    public CPU() {
        this.register = 1;
        this.currentCycle = 1;
        this.registerHistory = new HashMap<>();
    }

    public void applyCPUInstructions(List<CPUInstruction> cpuInstructions) {
        cpuInstructions.forEach(this::applyCPUInstruction);
    }

    private void applyCPUInstruction(CPUInstruction cpuInstruction) {
        if(cpuInstruction.instructionType() == NOOP) {
            registerHistory.put(currentCycle, register);
            currentCycle++;
        } else {
            registerHistory.put(currentCycle, register);
            currentCycle++;
            registerHistory.put(currentCycle, register);
            currentCycle++;
            register = register + cpuInstruction.value();
            registerHistory.put(currentCycle, register);
        }
    }

    public int computeSumSignalStrength(int startingCycle, int cycleOffset, int numberOfCycles) {
        int sumSignalStrength = registerHistory.get(startingCycle)*startingCycle;
        int cycle = startingCycle;
        while(numberOfCycles > 0) {
            cycle = cycle + cycleOffset;
            sumSignalStrength += registerHistory.get(cycle)*cycle;
            numberOfCycles--;
        }

        return sumSignalStrength;
    }
    public List<String> renderImage(List<CPUInstruction> cpuInstructions) {
        List<String> image = new ArrayList<>();
        image.add(INITIAL_LINE);
        image.add(INITIAL_LINE);
        image.add(INITIAL_LINE);
        image.add(INITIAL_LINE);
        image.add(INITIAL_LINE);
        image.add(INITIAL_LINE);
        for(CPUInstruction cpuInstruction : cpuInstructions) {
            applyInstructionToImage(cpuInstruction, image);
        }
        return image;
    }

    private void applyInstructionToImage(CPUInstruction cpuInstruction, List<String> image) {
        int currentIndex = (currentCycle - 1) % IMAGE_WIDTH;
        int currentRow = (currentCycle - 1)/IMAGE_WIDTH;
        String currentLine = image.get(currentRow);
        if (Objects.requireNonNull(cpuInstruction.instructionType()) == NOOP) {
            registerHistory.put(currentCycle, register);
            drawPixel(image, currentLine, currentIndex, currentRow);
            currentCycle++;
        } else {
            registerHistory.put(currentCycle, register);
            currentLine = drawPixel(image, currentLine, currentIndex, currentRow);
            currentCycle++;
            currentIndex++;
            if(currentIndex == IMAGE_WIDTH) {
                currentIndex = 0;
                ++currentRow;
                currentLine = image.get(currentRow);
            }
            registerHistory.put(currentCycle, register);
            currentLine = drawPixel(image, currentLine, currentIndex, currentRow);
            currentCycle++;
            currentIndex++;
            if(currentIndex == IMAGE_WIDTH) {
                currentIndex = 0;
                ++currentRow;
                currentLine = image.get(currentRow);
            }
            register = register + cpuInstruction.value();
            registerHistory.put(currentCycle, register);
            drawPixel(image, currentLine, currentIndex, currentRow);
        }
    }
    private String drawPixel(List<String> image, String currentLine, int currentIndex, int currentRow) {
        String drawnLine = currentLine;
        if(isInSpritePosition(currentIndex)) {
            StringBuilder stringBuilderToReplacePixel = new StringBuilder(drawnLine);
            stringBuilderToReplacePixel.setCharAt(currentIndex, '#');
            image.set(currentRow, stringBuilderToReplacePixel.toString());
            drawnLine =  stringBuilderToReplacePixel.toString();
        }
        return drawnLine;
    }
    private boolean isInSpritePosition(int currentIndex) {
        return Math.abs(register-currentIndex) < 2;
    }
}
