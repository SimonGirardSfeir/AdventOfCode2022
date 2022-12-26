package org.example.day15;

import org.example.common.Position;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public final class SensorAndBeaconResolver {
    private static final Pattern NOT_A_NEGATIVE_OR_POSITIVE_INTEGER_PATTERN = Pattern.compile("[^(\\-?\\d+)]");
    private SensorAndBeaconResolver(){
    }

    public static SensorAndBeaconPlan getSensorAndBeaconPlanFromLines(List<String> lines) {
        Set<SensorAndClosestBeacon> sensorAndBeacons = new HashSet<>();
        for(String line : lines) {
            SensorAndClosestBeacon sensorAndBeacon = getSensorAndBeaconFromLine(line);
            sensorAndBeacons.add(sensorAndBeacon);
        }
        return new SensorAndBeaconPlan(sensorAndBeacons);
    }

    private static SensorAndClosestBeacon getSensorAndBeaconFromLine(String line) {
        String[] splitLine = line.split(":");
        Position sensor = getPosition(splitLine[0]);
        Position closestBeacon = getPosition(splitLine[1]);
        return new SensorAndClosestBeacon(sensor, closestBeacon);
    }
    private static Position getPosition(String content) {
        Integer[] contents = Arrays.stream(NOT_A_NEGATIVE_OR_POSITIVE_INTEGER_PATTERN.matcher(content).
                                    replaceAll(" ").trim().split( " "))
                                        .filter(s -> !s.isBlank())
                                        .map(Integer::parseInt)
                                        .toArray(Integer[]::new);
        return new Position(contents[0], contents[1]);
    }
}
