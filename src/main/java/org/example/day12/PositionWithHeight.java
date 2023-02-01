package org.example.day12;

public record PositionWithHeight(int x, int y, char height) implements Comparable<PositionWithHeight> {
    @Override
    public int compareTo(PositionWithHeight o) {
        return Math.abs(x - o.x) + Math.abs(y - o.y) + Math.abs(height - o.height);
    }
}
