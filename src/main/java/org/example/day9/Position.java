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

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static Position of(int ropeSize) {
        Position position = new Position(0, 0);
        Position currentPosition = position;
        while(ropeSize > 0) {
            currentPosition.setPrevious(new Position(0,0));
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
    private boolean isCurrentPositionTouchingPrevious() {
        return !(Math.abs(previous.getX() - x) < 2 && (Math.abs(previous.getY() - y)) < 2);
    }

    private void applyDirectionToPreviousPosition() {
        if (isPreviousPositionCandidateToApplyDirection()) {
            if (y > previous.y && x < previous.x)
                previous.applyDirection(UPLEFT);
            else if (y > previous.y && x > previous.x)
                previous.applyDirection(UPRIGHT);
            else if (y < previous.y && x < previous.x)
                previous.applyDirection(DOWNLEFT);
            else if (y < previous.y && x > previous.x)
                previous.applyDirection(DOWNRIGHT);
            else if (y == previous.y && x < previous.x)
                previous.applyDirection(LEFT);
            else if (y == previous.y && x > previous.x)
                previous.applyDirection(RIGHT);
            else if (y > previous.y && x == previous.x)
                previous.applyDirection(UP);
            else if (y < previous.y && x == previous.x)
                previous.applyDirection(DOWN);

        }
    }

    private boolean isPreviousPositionCandidateToApplyDirection() {
        return previous != null && isCurrentPositionTouchingPrevious();
    }

    public Position getLastPosition() {
        Position currentPosition = this;
        while(currentPosition.previous != null) {
            currentPosition = currentPosition.previous;
        }
        return currentPosition;
    }

    private void setPrevious(Position position) {
        this.previous = position;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return  x + " " + y;
    }
}
