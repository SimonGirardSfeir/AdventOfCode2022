package org.example.day9;

/*
 * This class seems stupid?
 * Java does not have native Tuple object.
 */
public record Delta(int dx, int dy) implements Comparable<Delta> {
    @Override
    public int compareTo(Delta o) {
        return dx - o.dx + dy - o.dy;
    }
}
