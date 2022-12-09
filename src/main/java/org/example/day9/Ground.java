package org.example.day9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Ground {
    private final Position head;
    private final Set<String> positionsVisitedByTail = new HashSet<>();

    public Ground(int ropeSize) {
        this.head = Position.of(ropeSize);
    }

    public int countPositionsVisited(List<Instruction> instructions) {
        moveElements(instructions);
        return positionsVisitedByTail.size();
    }

    public void moveElements(List<Instruction> instructions) {
        instructions.forEach(this::applyInstruction);
    }

    private void applyInstruction(Instruction instruction) {
        int stepsRemaining = instruction.stepsNumber();
        while(stepsRemaining > 0) {
            head.applyDirection(instruction.direction());
            Position lastPosition = head.getLastPosition();
            positionsVisitedByTail.add(lastPosition.toString());
            stepsRemaining--;
        }
    }
}
