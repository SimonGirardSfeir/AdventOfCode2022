package org.example.day15;

import org.example.common.Position;

import java.util.HashSet;
import java.util.Set;

public record SensorAndBeaconPlan(Set<SensorAndClosestBeacon> sensorAndBeacons) {
    private static final long MULTIPLIER = 4000000L;
    public int countExcludedPositionsInARow(int rowNumber) {
        int numberOfExcludedPositionsInRow = 0;
        Set<Position> occupiedPoints = new HashSet<>();
        Row row = new Row();

        for(SensorAndClosestBeacon sensorAndClosestBeacon : sensorAndBeacons) {
            occupiedPoints.add(sensorAndClosestBeacon.sensor());
            occupiedPoints.add(sensorAndClosestBeacon.closestBeacon());
            CoveredZone exclusionZone = sensorAndClosestBeacon.getExclusionZone(rowNumber);
            if(exclusionZone != null)
                row.addCoveredZone(exclusionZone);
        }

        for(CoveredZone coveredZone : row.coveredZones()) {
            numberOfExcludedPositionsInRow += coveredZone.getLength();
        }
        numberOfExcludedPositionsInRow = removeSensorAndBeaconFromExcludedPositions(rowNumber,
                numberOfExcludedPositionsInRow, occupiedPoints);
        return numberOfExcludedPositionsInRow;
    }

    private static int removeSensorAndBeaconFromExcludedPositions(int rowNumber, int count,
                                                                  Set<Position> occupiedPoints) {
        for(Position position : occupiedPoints) {
            if(position.y() == rowNumber)
                count--;
        }
        return count;
    }

    public long computeTuningFrequency(int upperLimit) {
        int x = 0;
        int y = 0;

        for(int i = 0; i <= upperLimit; i++) {
            Row row = new Row(upperLimit);
            for(SensorAndClosestBeacon sensorAndClosestBeacon : sensorAndBeacons) {
                CoveredZone exclusionZone = sensorAndClosestBeacon.getExclusionZone(i);
                if(exclusionZone != null)
                    row.addCoveredZone(exclusionZone);
                if(row.isFull())
                    break;
            }
            if(!row.isFull()) {
                x = row.getFreePositionInRow();
                y = i;
                break;
            }

        }
        return x*MULTIPLIER + y;
    }
}
