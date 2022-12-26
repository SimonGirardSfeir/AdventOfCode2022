package org.example.common;

public record Position(int x, int y) implements Comparable<Position> {
    @Override
    public int compareTo(Position o) {
        return Math.abs(x - o.x) + Math.abs(y - o.y);
    }
}
