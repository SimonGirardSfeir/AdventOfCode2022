package org.example.day12;

import org.example.common.Direction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PlanResolver {
    private PlanResolver(){
    }

    public static Plan getPlanFromLines(List<String> lines, boolean isReversePath) {
        int horizontalLength = lines.getFirst().length();
        int verticalLength = lines.size();
        char[][] points = new char[verticalLength][];
        for (int i = 0; i < verticalLength; i++) {
            char[] array = new char[horizontalLength];
            for (int j = 0; j < horizontalLength; j++) {
                array[j] = lines.get(i).charAt(j);
            }
            points[i] = array;
        }

        Map<PositionWithHeight, List<PositionWithHeight>> positionsAndAdjacent =
                generatePositionsAndAdjacent(points, isReversePath);

        return new Plan(positionsAndAdjacent);
    }
    private static Map<PositionWithHeight, List<PositionWithHeight>>
    generatePositionsAndAdjacent(char[][] points, boolean isReversePath) {
        Map<PositionWithHeight, List<PositionWithHeight>> map = new HashMap<>();
        int horizontalLength = points.length;
        int verticalLength = points[0].length;
        for (int i = 0; i < horizontalLength; i++) {
            for (int j = 0; j < verticalLength; j++) {
                List<PositionWithHeight> adjacentPosition = new ArrayList<>();
                PositionWithHeight position = new PositionWithHeight(i, j, points[i][j]);
                map.put(position, adjacentPosition);
                checkReachable(points, position, adjacentPosition, Direction.UP, isReversePath);
                checkReachable(points, position, adjacentPosition, Direction.DOWN, isReversePath);
                checkReachable(points, position, adjacentPosition, Direction.LEFT, isReversePath);
                checkReachable(points, position, adjacentPosition, Direction.RIGHT, isReversePath);
            }
        }
        return map;
    }
    private static void checkReachable(char[][] points, PositionWithHeight currentPosition,
                                       List<PositionWithHeight> adjacentPositions,
                                       Direction direction, boolean reverse) {
        int x = currentPosition.x();
        int y = currentPosition.y();
        int xTarget = x + direction.getDx();
        int yTarget = y + direction.getDy();
        int verticalLength = points[0].length;
        int horizontalLength = points.length;

        if(isAdjacentOnPlan(xTarget, yTarget, horizontalLength, verticalLength) &&
                isReachable(points[x][y], points[xTarget][yTarget], reverse))
            adjacentPositions.add(new PositionWithHeight(xTarget, yTarget, points[xTarget][yTarget]));
    }
    private static boolean isReachable(char source, char target, boolean isReversePath) {
        /*
         *  Characters represent here elevation of the map.
         *  Except the one that represents starting point ('S') which is of elevation 'a'
         *  and the one that represents ending point ('E') which is of elevation 'z'.
         *  Here's why conversion above
         */
        if(source == 'E')
            source = 'z';
        if(target == 'E')
            target = 'z';
        if(source == 'S')
            source = 'a';
        if(target == 'S')
            target = 'a';
        if(isReversePath)
            return source - target < 2;
        else
            return target - source < 2;
    }
    private static boolean isAdjacentOnPlan(int x, int y, int upperHorizontalLimit,
                                           int upperVerticalLimit) {
        return x >= 0 && x < upperHorizontalLimit && y >= 0 && y < upperVerticalLimit;
    }
}
