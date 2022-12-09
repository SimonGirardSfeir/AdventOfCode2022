package org.example.day9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Ground {
    private final Position tail;
    private final Position head;

    public Ground(Position tail, Position head) {
        this.tail = tail;
        this.head = head;
    }

    private final Set<Position> positionsVisitedByTail = new HashSet<>();

    public int countPositionsVisited(List<Instruction> instructions) {
        moveElements(instructions);
        return positionsVisitedByTail.size();
    }

    public void moveElements(List<Instruction> instructions) {
        instructions.forEach(this::applyInstruction);
    }

    private void applyInstruction(Instruction instruction) {
        switch (instruction.direction()) {
            case RIGHT -> performRight(instruction.stepsNumber());
            case LEFT -> performLeft(instruction.stepsNumber());
            case UP -> performUp(instruction.stepsNumber());
            case DOWN -> performDown(instruction.stepsNumber());
        }
    }

    private void performRight(int stepNumbers) {
        while (stepNumbers > 0) {
            head.setX(head.x() + 1);
            if (isTailNotTouchingHead()) {
                tail.setX(tail.x() + 1);
                if (head.y() != tail.y())
                    tail.setY(head.y());
            }
            addPosistionsVisitedByTail();
            stepNumbers--;
        }
    }
    private void performLeft(int stepNumbers) {
        while (stepNumbers > 0) {
            head.setX(head.x() - 1);
            if (isTailNotTouchingHead()) {
                tail.setX(tail.x() - 1);
                if (head.y() != tail.y())
                    tail.setY(head.y());
            }
            addPosistionsVisitedByTail();
            stepNumbers--;
        }
    }

    void performUp(int stepNumbers) {
        while (stepNumbers > 0) {
            head.setY(head.y() + 1);
            if (isTailNotTouchingHead()) {
                tail.setY(tail.y() + 1);
                if (head.x() != tail.x())
                    tail.setX(head.x());
            }
            addPosistionsVisitedByTail();
            stepNumbers--;
        }
    }

    void performDown(int stepNumbers) {
        while (stepNumbers > 0) {
            head.setY(head.y() - 1);
            if (isTailNotTouchingHead()) {
                tail.setY(tail.y() - 1);
                if (head.x() != tail.x())
                    tail.setX(head.x());
            }
            addPosistionsVisitedByTail();
            stepNumbers--;
        }
    }
    private boolean isTailNotTouchingHead() {
        return !(Math.abs(head.x() - tail.x()) < 2 && Math.abs(head.y() - tail.y()) < 2);
    }
    private void addPosistionsVisitedByTail() {
        positionsVisitedByTail.add(new Position(tail.x(), tail.y()));
    }

    public Position tail() {
        return tail;
    }
    public Position head() {
        return head;
    }
}
