package org.example.day14;

import org.example.common.Position;

import java.util.Set;

public abstract class Cave {
    protected static final int SAND_POURING_POSITION_X = 500;
    protected static final int SAND_POURING_POSITION_Y = 0;
    protected final Set<Position> rocks;
    protected final Set<Position> sands;
    protected final int maxDepth;
    protected final int maxLeft;
    protected final int maxRight;

    protected Cave(Set<Position> rocks, Set<Position> sands, int maxDepth, int maxLeft, int maxRight) {
        this.rocks = rocks;
        this.sands = sands;
        this.maxDepth = maxDepth;
        this.maxLeft = maxLeft;
        this.maxRight = maxRight;
    }

    public int countUnitsOfSandResting() {
        int currentSize = 0;

        while (true) {
            Position sandToAdd = addSandUnit();
            sands.add(sandToAdd);

            if (sands.size() == currentSize)
                break;

            currentSize = sands.size();
        }
        return sands.size();
    }

    protected Position addSandUnit() {
        int xSand = SAND_POURING_POSITION_X;
        int ySand = SAND_POURING_POSITION_Y;
        while (isPossibleToAddSandUnit(xSand, ySand)) {
            if (isPositionMustGoDown(xSand, ySand))
                ySand++;
            if (isPositionMustGoDownLeft(xSand, ySand)) {
                xSand--;
                ySand++;
            }
            if (isPositionMustGoDownRight(xSand, ySand)) {
                xSand++;
                ySand++;
            }
            if (isStableAround(xSand, ySand))
                return new Position(xSand, ySand);

        }

        return sands.toArray(Position[]::new)[0];
    }

    protected abstract boolean isPossibleToAddSandUnit(int xSand, int ySand);
    protected boolean isPositionMustGoDown(int x, int y) {
        return !isPositionOccupied(x, y + 1);
    }
    protected boolean isPositionMustGoDownRight(int x, int y) {
        return isPositionOccupied(x, y + 1) && isPositionOccupied(x - 1, y + 1) && !isPositionOccupied(x + 1, y + 1);
    }
    protected boolean isPositionMustGoDownLeft(int x, int y) {
        return isPositionOccupied(x, y + 1) && !isPositionOccupied(x - 1, y + 1);
    }
    protected boolean isStableAround(int x, int y) {
        return (isPositionOccupied(x, y + 1) && isPositionOccupied(x + 1, y + 1) && isPositionOccupied(x - 1, y + 1));
    }
    protected abstract boolean isPositionOccupied(int x, int y);
}
