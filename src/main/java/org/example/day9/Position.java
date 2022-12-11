package org.example.day9;

import static org.example.day9.Direction.DOWN;
import static org.example.day9.Direction.DOWNLEFT;
import static org.example.day9.Direction.DOWNRIGHT;
import static org.example.day9.Direction.LEFT;
import static org.example.day9.Direction.RIGHT;
import static org.example.day9.Direction.UP;
import static org.example.day9.Direction.UPLEFT;
import static org.example.day9.Direction.UPRIGHT;

public final class Position {
    private int x;
    private int y;
    private Position previous;

    private Position() {
        this.x = 0;
        this.y = 0;
    }

    public static Position of(int ropeSize) {
        Position position = new Position();
        Position currentPosition = position;
        while(ropeSize > 0) {
            currentPosition.previous = new Position();
            currentPosition = currentPosition.previous;
            ropeSize--;
        }
        return position;
    }

    public void applyDirection(Direction direction) {
        switch (direction) {
            case UP -> y++;
            case DOWN -> y--;
            case RIGHT -> x++;
            case LEFT -> x--;
            case UPRIGHT -> {
                x++;
                y++;
            }
            case UPLEFT -> {
                x--;
                y++;
            }
            case DOWNRIGHT -> {
                x++;
                y--;
            }
            case DOWNLEFT -> {
                x--;
                y--;
            }
        }
        applyDirectionToPreviousPosition();
    }
    public Position getLastPosition() {
        Position currentPosition = this;
        while(currentPosition.previous != null) {
            currentPosition = currentPosition.previous;
        }
        return currentPosition;
    }
    private void applyDirectionToPreviousPosition() {
        if (isPreviousPositionCandidateToApplyDirection()) {
            if (isNextDirectionUpLeft())
                previous.applyDirection(UPLEFT);
            else if (isNextDirectionUpRight())
                previous.applyDirection(UPRIGHT);
            else if (isNextDirectionDownLeft())
                previous.applyDirection(DOWNLEFT);
            else if (isNextDirectionDownRight())
                previous.applyDirection(DOWNRIGHT);
            else if (y == previous.y && x < previous.x)
                previous.applyDirection(LEFT);
            else if (y == previous.y && x > previous.x)
                previous.applyDirection(RIGHT);
            else if (y > previous.y)
                previous.applyDirection(UP);
            else if (y < previous.y)
                previous.applyDirection(DOWN);

        }
    }
    private boolean isCurrentPositionTouchingPrevious() {
        return !(Math.abs(previous.x - x) < 2 && (Math.abs(previous.y - y)) < 2);
    }
    private boolean isNextDirectionDownRight() {
        return y < previous.y && x > previous.x;
    }
    private boolean isNextDirectionDownLeft() {
        return y < previous.y && x < previous.x;
    }
    private boolean isNextDirectionUpRight() {
        return y > previous.y && x > previous.x;
    }
    private boolean isNextDirectionUpLeft() {
        return y > previous.y && x < previous.x;
    }
    private boolean isPreviousPositionCandidateToApplyDirection() {
        return previous != null && isCurrentPositionTouchingPrevious();
    }

    @Override
    public String toString() {
        return  x + " " + y;
    }
}
