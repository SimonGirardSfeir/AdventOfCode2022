package org.example.day9;

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
            case UP -> y = y+1;
            case DOWN -> y = y-1;
            case RIGHT -> x = x+1;
            case LEFT -> x = x-1;
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
            int dx = x - previous.x;
            int dy = y - previous.y;
            if(dx != 0)
                dx = dx/Math.abs(dx);
            if(dy != 0)
                dy = dy/Math.abs(dy);

            previous.applyDirection(Direction.valueOfDelta(dx, dy));

        }
    }
    private boolean isCurrentPositionTouchingPrevious() {
        return !(Math.abs(previous.x - x) < 2 && (Math.abs(previous.y - y)) < 2);
    }
    private boolean isPreviousPositionCandidateToApplyDirection() {
        return previous != null && isCurrentPositionTouchingPrevious();
    }

    @Override
    public String toString() {
        return  x + " " + y;
    }
}
