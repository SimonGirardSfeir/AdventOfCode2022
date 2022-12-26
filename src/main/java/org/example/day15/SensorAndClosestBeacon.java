package org.example.day15;

import org.example.common.Position;

public record SensorAndClosestBeacon(Position sensor, Position closestBeacon) {
    public CoveredZone getExclusionZone(int rowNumber) {
        int manhattanDistanceBetweenSensorAndClosestBeacon = getManhattanDistance();
        int verticalDistanceBetweenSensorAndCurrentRow = Math.abs(rowNumber - sensor.y());

        int excludedDistanceInRow = manhattanDistanceBetweenSensorAndClosestBeacon - verticalDistanceBetweenSensorAndCurrentRow;

        return (excludedDistanceInRow > 0) ?
                new CoveredZone(sensor.x() - excludedDistanceInRow, sensor.x() + excludedDistanceInRow) : null;
    }
    public int getManhattanDistance() {
        return Math.abs(sensor.x() - closestBeacon.x()) + Math.abs(sensor.y() - closestBeacon.y());
    }
}
