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


    public int findPathLengthForUniqueSource(char startingCharacter, char endingCharacter) {
        int horizontalLength = points.length;
        int verticalLength = points[0].length;


        for (int i = 0; i < horizontalLength; i++) {
            for (int j = 0; j < verticalLength; j++) {
                List<Position> adjacentPosition = new ArrayList<>();
                Position position = new Position(i, j);
                positionsAndAdjacent.put(position, adjacentPosition);
                checkNorth(i, j, adjacentPosition, false);
                checkSouth(i, j, adjacentPosition, false);
                checkWest(i, j, adjacentPosition, false);
                checkEast(i, j, adjacentPosition, false);
            }
        }
        Position startPosition = findUniquePosition(startingCharacter);
        Position endingPosition = findUniquePosition(endingCharacter);

        List<Position> path = endingPosition != null ?
                getPathBFS(startPosition, List.of(endingPosition)) : Collections.emptyList();

        return path.size() - 1;
    }

    public int findPathLengthForMultipleSource(char startingCharacter, char endingCharacter) {
        int horizontalLength = points.length;
        int verticalLength = points[0].length;


        for (int i = 0; i < horizontalLength; i++) {
            for (int j = 0; j < verticalLength; j++) {
                List<Position> adjacentPosition = new ArrayList<>();
                Position position = new Position(i, j);
                positionsAndAdjacent.put(position, adjacentPosition);
                checkNorth(i, j, adjacentPosition, true);
                checkSouth(i, j, adjacentPosition, true);
                checkWest(i, j, adjacentPosition, true);
                checkEast(i, j, adjacentPosition, true);
            }
        }
        Position startPosition = findUniquePosition(endingCharacter);
        List<Position> endingPositions = findListPosition(startingCharacter);

        List<Position> path = getPathBFS(startPosition, endingPositions);


        return path.size() - 1;
    }

    private List<Position> getPathBFS(Position startPosition, List<Position> endingPositions) {
        boolean found = false;
        Set<Position> visited = new HashSet<>();
        visited.add(startPosition);

        Queue<Position> positionQueue = new ArrayDeque<>();
        positionQueue.add(startPosition);

        Map<Position, Position> parents = new HashMap<>();
        parents.put(startPosition, null);

        Position target = null;

        while(!positionQueue.isEmpty()) {
            Position currentPosition = positionQueue.remove();

            if(endingPositions.contains(currentPosition)) {
                target = currentPosition;
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

        List<Position> path = new ArrayList<>();
        if(found) {
            Position end = target;
            path.add(end);
            while(parents.get(end) != null) {
                path.add(parents.get(end));
                end = parents.get(end);
            }
        }

        return path;
    }

    private void checkNorth(int i, int j, List<Position> adjacentPositions, boolean reverse) {
        if(j < points[0].length -1 && isNeighbor(points[i][j], points[i][j + 1], reverse))
            adjacentPositions.add(new Position(i, j + 1));
    }
    private void checkSouth(int i, int j, List<Position> adjacentPositions, boolean reverse) {
        if(j > 0 && isNeighbor(points[i][j], points[i][j - 1], reverse))
            adjacentPositions.add(new Position(i, j - 1));
    }
    private void checkWest(int i, int j, List<Position> adjacentPositions, boolean reverse) {
        if(i > 0 && isNeighbor(points[i][j], points[i-1][j], reverse))
            adjacentPositions.add(new Position(i-1, j));
    }
    private void checkEast(int i, int j, List<Position> adjacentPositions, boolean reverse) {
        if(i < points.length -1  && isNeighbor(points[i][j], points[i+1][j], reverse))
            adjacentPositions.add(new Position(i+1, j));
    }
    private boolean isNeighbor(char source, char target, boolean reverse) {
        if(reverse)
            return (source - target < 2 && source != 'E') || (source == 'E' && target == 'z') ||
                    ((source == 'a' || source == 'b') && target == 'S');
        else
            return (target - source < 2 && target != 'E') || target == 'S' || (source == 'S' && target == 'a')
                || (source == 'z' && target == 'E');
    }
}

