package org.example.day15;

import org.example.common.Position;

public record SensorAndClosestBeacon(Position sensor, Position closestBeacon) {
    public CoveredZone getExclusionZone(int rowNumber, int lowerLimit, int upperLimit) {
        int manhattanDistanceBetweenSensorAndClosestBeacon = getManhattanDistance();
        int verticalDistanceBetweenSensorAndCurrentRow = Math.abs(rowNumber - sensor.y());

        int excludedDistanceInRow = manhattanDistanceBetweenSensorAndClosestBeacon - verticalDistanceBetweenSensorAndCurrentRow;
        int xMax = Math.min(upperLimit, sensor.x() + excludedDistanceInRow);
        int xMin = Math.max(lowerLimit, sensor.x() - excludedDistanceInRow);

        return (excludedDistanceInRow > 0) ? new CoveredZone(xMin, xMax) : null;
    }
    public int getManhattanDistance() {
        return Math.abs(sensor.x() - closestBeacon.x()) + Math.abs(sensor.y() - closestBeacon.y());
    }
}
