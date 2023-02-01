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

public record Plan(Map<PositionWithHeight, List<PositionWithHeight>> positionsAndAdjacent) {
    public int findPathLengthForUniqueSource(char startingCharacter, char endingCharacter) {
        PositionWithHeight startPosition = findUniquePosition(startingCharacter);
        PositionWithHeight endingPosition = findUniquePosition(endingCharacter);

        Set<PositionWithHeight> path = endingPosition != null ?
                getPath(startPosition, List.of(endingPosition)) : Collections.emptySet();

        return path.size() - 1;
    }
    public int findPathLengthForMultipleSource(char startingCharacter, char endingCharacter) {
        PositionWithHeight startPosition = findUniquePosition(endingCharacter);
        List<PositionWithHeight> endingPositions = findListPosition(startingCharacter);

        Set<PositionWithHeight> path = getPath(startPosition, endingPositions);

        return path.size() - 1;
    }

    private PositionWithHeight findUniquePosition(char value) {
        for (Map.Entry<PositionWithHeight, List<PositionWithHeight>> entry : positionsAndAdjacent.entrySet()) {
            if(entry.getKey().height() == value)
                return entry.getKey();
        }
        return null;
    }

    private List<PositionWithHeight> findListPosition(char value) {
        List<PositionWithHeight> positions = new ArrayList<>();
        for (Map.Entry<PositionWithHeight, List<PositionWithHeight>> entry : positionsAndAdjacent.entrySet()) {
            if(entry.getKey().height() == value)
                positions.add(entry.getKey());
        }
        return positions;
    }
    private Set<PositionWithHeight> getPath(PositionWithHeight startPosition,
                                            List<PositionWithHeight> endingPositions) {
        boolean found = false;
        Set<PositionWithHeight> visited = new HashSet<>();
        visited.add(startPosition);
        Queue<PositionWithHeight> positionQueue = new ArrayDeque<>();
        positionQueue.add(startPosition);
        Map<PositionWithHeight, PositionWithHeight> parents = new HashMap<>();
        parents.put(startPosition, null);
        PositionWithHeight targetPosition = null;

        while(!positionQueue.isEmpty()) {
            PositionWithHeight currentPosition = positionQueue.remove();

            if(endingPositions.contains(currentPosition)) {
                targetPosition = currentPosition;
                found = true;
                break;
            }

            List<PositionWithHeight> neighbors = positionsAndAdjacent.get(currentPosition);

            for(PositionWithHeight p : neighbors) {
                if(!visited.contains(p)) {
                    visited.add(p);
                    positionQueue.add(p);
                    parents.put(p, currentPosition);
                }
            }
        }

        Set<PositionWithHeight> path = new HashSet<>();
        if(found) {
            PositionWithHeight end = targetPosition;
            path.add(end);
            while(parents.get(end) != null) {
                path.add(parents.get(end));
                end = parents.get(end);
            }
        }

        return path;
    }
}

