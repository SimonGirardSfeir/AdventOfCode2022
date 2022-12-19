package org.example.day14;

import org.example.common.Position;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public record Cave(Set<Position> rocks, Set<Position> sands, int maxDepth, int maxLeft, int maxRight) {
    public static Cave of(List<String> lines) {
        Set<Position> rocks = new HashSet<>();
        for(String line : lines) {
            Position[] cornerPositions = Arrays.stream(line.split(" -> "))
                    .map(s ->
                            new Position(Integer.parseInt(s.split(",")[0]), Integer.parseInt(s.split(",")[1])))
                    .toArray(Position[]::new);
            Set<Position> positionsToPopulate = populateRocks(cornerPositions);
            rocks.addAll(positionsToPopulate);
        }
        int maxDepth = rocks.stream()
                .max(Comparator.comparing(Position::y))
                .orElseThrow(NoSuchElementException::new).y();
        int maxLeft = rocks.stream()
                .min(Comparator.comparing(Position::x))
                .orElseThrow(NoSuchElementException::new).x();
        int maxRight = rocks.stream()
                .max(Comparator.comparing(Position::x))
                .orElseThrow(NoSuchElementException::new).x();
        return new Cave(rocks, new HashSet<>(), maxDepth, maxLeft, maxRight);
    }

    private static Set<Position> populateRocks(Position[] cornerPositions) {
        Set<Position> positions = new HashSet<>();
        for(int i = 0; i < cornerPositions.length -1; i++) {
            Position currentPosition = cornerPositions[i];
            Position nextPosition = cornerPositions[i+1];
            if(currentPosition.x() < nextPosition.x()) {
                positions.addAll(populateHorizontally(currentPosition.x(), nextPosition.x(), currentPosition.y()));
            } else if(currentPosition.x() > nextPosition.x()) {
                positions.addAll(populateHorizontally(nextPosition.x(), currentPosition.x(), currentPosition.y()));
            } else if(currentPosition.y() < nextPosition.y()) {
                positions.addAll(populateVertically(currentPosition.y(), nextPosition.y(), currentPosition.x()));
            } else if(currentPosition.y() > nextPosition.y()) {
                positions.addAll(populateVertically(nextPosition.y(), currentPosition.y(), currentPosition.x()));
            }

        }
        return positions;
    }

    private static Set<Position> populateVertically(int y1, int y2, int x) {
        Set<Position> positions = new HashSet<>();
        for(int i = y1; i <= y2; i++) {
            positions.add(new Position(x, i));
        }
        return positions;
    }
    private static Set<Position> populateHorizontally(int x1, int x2, int y) {
        Set<Position> positions = new HashSet<>();
        for(int i = x1; i <= x2; i++) {
            positions.add(new Position(i, y));
        }
        return positions;
    }

    public int countUnitsOfSandResting() {
        int currentSize = 0;

        while (true){
            Position sandToAdd = addSandUnit();
            sands.add(sandToAdd);

            if(sands.size() == currentSize)
                break;

            currentSize = sands.size();
        }
        return sands.size();
    }

    private Position addSandUnit() {
        int xSand = 500;
        int ySand = 0;
        while(ySand < maxDepth && xSand > maxLeft && xSand < maxRight) {
            if(isPositionMustGoDown(xSand, ySand))
                ySand++;
            if(isPositionMustGoDownLeft(xSand, ySand)) {
                xSand--;
                ySand++;
            }
            if(isPositionMustGoDownRight(xSand, ySand)) {
                xSand++;
                ySand++;
            }
            if(isStableAround(xSand, ySand))
                return new Position(xSand, ySand);

        }

        return sands.toArray(Position[]::new)[0];
    }

    private boolean isPositionMustGoDown(int x, int y) {
        return !isPositionOccupied(x, y+1);
    }
    private boolean isPositionMustGoDownRight(int x, int y) {
        return isPositionOccupied(x, y+1) && isPositionOccupied(x-1, y+1) && !isPositionOccupied(x+1, y+1);
    }

    private boolean isPositionMustGoDownLeft(int x, int y) {
        return isPositionOccupied(x, y+1) && !isPositionOccupied(x-1, y+1);
    }

    private boolean isStableAround(int x, int y) {
        return (isPositionOccupied(x, y+1) && isPositionOccupied(x+1, y+1) && isPositionOccupied(x-1, y+1));
    }
    private boolean isPositionOccupied(int x, int y) {
        Position position = new Position(x, y);
        return rocks.contains(position) || sands.contains(position);
    }
}
