package org.example.day14;

import org.example.common.Position;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CaveResolver {
    private static final Pattern POSITION_REGEX = Pattern.compile("\\d+,\\d+");
    private CaveResolver(){
    }

    public static UnrealisticCave getUnrealisticCaveFromLines(List<String> lines) {
        Set<Position> rocks = generateRocks(lines);
        return new UnrealisticCave(rocks, new HashSet<>(), getMaxDepth(rocks), getMaxLeft(rocks), getMaxRight(rocks));
    }
    public static RealisticCave getRealisticCaveFromLines(List<String> lines) {
        Set<Position> rocks = generateRocks(lines);
        return new RealisticCave(rocks, new HashSet<>(), getMaxDepth(rocks), getMaxLeft(rocks), getMaxRight(rocks));
    }
    private static int getMaxDepth(Set<Position> rocks) {
        return rocks.stream()
                .max(Comparator.comparing(Position::y))
                .orElseThrow(NoSuchElementException::new).y();
    }
    private static int getMaxLeft(Set<Position> rocks) {
        return rocks.stream()
                .min(Comparator.comparing(Position::x))
                .orElseThrow(NoSuchElementException::new).x();
    }
    private static int getMaxRight(Set<Position> rocks) {
        return rocks.stream()
                .max(Comparator.comparing(Position::x))
                .orElseThrow(NoSuchElementException::new).x();
    }
    private static Set<Position> generateRocks(List<String> lines) {
        Set<Position> rocks = new HashSet<>();
        for(String line : lines) {
            Matcher matcher = POSITION_REGEX.matcher(line);
            List<Position> cornerPositions = new ArrayList<>();
            while(matcher.find()) {
                String positionAsString = matcher.group();
                cornerPositions.add(new Position(Integer.parseInt(positionAsString.split(",")[0]),
                        Integer.parseInt(positionAsString.split(",")[1])));
            }
            Set<Position> positionsToPopulate = populateRocks(cornerPositions.toArray(Position[]::new));
            rocks.addAll(positionsToPopulate);
        }
        return rocks;
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
            } else {
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
}
