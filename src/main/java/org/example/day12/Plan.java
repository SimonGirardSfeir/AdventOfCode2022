package org.example.day12;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static org.example.day12.PlanResolver.isReachable;

public final class Plan {
    private final char[][] points;

    private final Map<Position, List<Position>> positionsAndAdjacent = new HashMap<>();

    public Plan(char[][] points) {
        this.points = points;
    }

    public static Plan of(List<String> lines) {
        int horizontalLength = lines.get(0).length();
        int verticalLength = lines.size();
        char[][] points = new char[verticalLength][];
        for (int i = 0; i < verticalLength; i++) {
            char[] array = new char[horizontalLength];
            for (int j = 0; j < horizontalLength; j++) {
                array[j] = lines.get(i).charAt(j);
            }
            points[i] = array;
        }


        return new Plan(points);
    }

    public int findPathLengthForUniqueSource(char startingCharacter, char endingCharacter) {
        Position startPosition = findUniquePosition(startingCharacter);
        Position endingPosition = findUniquePosition(endingCharacter);

        generatePositionsAndAdjacent(false);

        Set<Position> path = endingPosition != null ?
                getPath(startPosition, List.of(endingPosition)) : Collections.emptySet();

        return path.size() - 1;
    }
    public int findPathLengthForMultipleSource(char startingCharacter, char endingCharacter) {
        Position startPosition = findUniquePosition(endingCharacter);
        List<Position> endingPositions = findListPosition(startingCharacter);

        generatePositionsAndAdjacent(true);

        Set<Position> path = getPath(startPosition, endingPositions);

        return path.size() - 1;
    }

    private Position findUniquePosition(char value) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                if (points[i][j] == value) {
                    return new Position(i, j);
                }
            }
        }
        return null;
    }

    private List<Position> findListPosition(char value) {
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
                if (points[i][j] == value) {
                    positions.add(new Position(i, j));
                }
            }
        }
        return positions;
    }
    private void generatePositionsAndAdjacent(boolean isReversePath) {
        int horizontalLength = points.length;
        int verticalLength = points[0].length;
        for (int i = 0; i < horizontalLength; i++) {
            for (int j = 0; j < verticalLength; j++) {
                List<Position> adjacentPosition = new ArrayList<>();
                Position position = new Position(i, j);
                positionsAndAdjacent.put(position, adjacentPosition);
                checkReachable(position, adjacentPosition, Direction.NORTH, isReversePath);
                checkReachable(position, adjacentPosition, Direction.SOUTH, isReversePath);
                checkReachable(position, adjacentPosition, Direction.WEST, isReversePath);
                checkReachable(position, adjacentPosition, Direction.EAST, isReversePath);
            }
        }
    }
    private Set<Position> getPath(Position startPosition, List<Position> endingPositions) {
        boolean found = false;
        Set<Position> visited = new HashSet<>();
        visited.add(startPosition);
        Queue<Position> positionQueue = new ArrayDeque<>();
        positionQueue.add(startPosition);
        Map<Position, Position> parents = new HashMap<>();
        parents.put(startPosition, null);
        Position targetPosition = null;

        while(!positionQueue.isEmpty()) {
            Position currentPosition = positionQueue.remove();

            if(endingPositions.contains(currentPosition)) {
                targetPosition = currentPosition;
                found = true;
                break;
            }

            List<Position> neighbors = positionsAndAdjacent.get(currentPosition);

            for(Position p : neighbors) {
                if(!visited.contains(p)) {
                    visited.add(p);
                    positionQueue.add(p);
                    parents.put(p, currentPosition);
                }
            }
        }

        Set<Position> path = new HashSet<>();
        if(found) {
            Position end = targetPosition;
            path.add(end);
            while(parents.get(end) != null) {
                path.add(parents.get(end));
                end = parents.get(end);
            }
        }

        return path;
    }
    private void checkReachable(Position currentPosition, List<Position> adjacentPositions, Direction direction, boolean reverse) {
        int x = currentPosition.x();
        int y = currentPosition.y();
        switch (direction) {
            case NORTH -> {
                if(y < points[0].length -1 && isReachable(points[x][y], points[x][y + 1], reverse))
                    adjacentPositions.add(new Position(x, y + 1));
            }
            case SOUTH -> {
                if(y > 0 && isReachable(points[x][y], points[x][y - 1], reverse))
                    adjacentPositions.add(new Position(x, y - 1));
            }
            case EAST -> {
                if(x < points.length -1  && isReachable(points[x][y], points[x+1][y], reverse))
                    adjacentPositions.add(new Position(x+1, y));
            }
            case WEST -> {
                if(x > 0 && isReachable(points[x][y], points[x-1][y], reverse))
                    adjacentPositions.add(new Position(x-1, y));
            }
        }
    }
}

