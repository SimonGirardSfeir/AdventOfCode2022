package org.example.day14;

import org.example.common.Position;

import java.util.Set;

public class UnrealisticCave extends AbstractCave {
    public UnrealisticCave(Set<Position> rocks, Set<Position> sands, int maxDepth, int maxLeft, int maxRight) {
        super(rocks, sands, maxDepth, maxLeft, maxRight);
    }

    @Override
    protected boolean isPossibleToAddSandUnit(int xSand, int ySand) {
        return ySand < maxDepth && xSand > maxLeft && xSand < maxRight;
    }
    @Override
    protected boolean isPositionOccupied(int x, int y) {
        Position position = new Position(x, y);
        return rocks.contains(position) || sands.contains(position);
    }
}
