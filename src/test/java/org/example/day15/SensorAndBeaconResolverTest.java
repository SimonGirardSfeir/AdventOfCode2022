package org.example.day15;

import org.example.LineExtractor;
import org.example.common.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SensorAndBeaconResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day15/inputData.txt");
    }

    @Test
    void getSensorAndBeaconPlanFromLines_should_generate_sensor_and_beacon_plan_from_lines() {
        //Given
        String line1 = "Sensor at x=2, y=18: closest beacon is at x=-2, y=15";
        String line2 = "Sensor at x=9, y=16: closest beacon is at x=10, y=16";
        List<String> givenLines = List.of(line1, line2);

        //When
        SensorAndBeaconPlan sensorAndBeaconPlan = SensorAndBeaconResolver.getSensorAndBeaconPlanFromLines(givenLines);

        //Then
        Position sensor1 = new Position(2,18);
        Position beacon1 = new Position(-2,15);
        SensorAndClosestBeacon expectedSensorAndBeacon1 = new SensorAndClosestBeacon(sensor1, beacon1);
        Position sensor2 = new Position(9,16);
        Position beacon2 = new Position(10,16);
        SensorAndClosestBeacon expectedSensorAndBeacon2 = new SensorAndClosestBeacon(sensor2, beacon2);
        SensorAndBeaconPlan expectedSensorAndBeaconPlan = new SensorAndBeaconPlan(Set.of(expectedSensorAndBeacon1,
                expectedSensorAndBeacon2));
        assertThat(sensorAndBeaconPlan).isEqualTo(expectedSensorAndBeaconPlan);
    }

    @Test
    void resolve_part1_of_day15_problem() {
        //Given
        SensorAndBeaconPlan givenSensorAndBeaconPlan = SensorAndBeaconResolver.getSensorAndBeaconPlanFromLines(lines);

        //When
        int numberOfExcludedPositionsInARow = givenSensorAndBeaconPlan.countExcludedPositionsInARow(2000000);

        //Then
        assertThat(numberOfExcludedPositionsInARow).isEqualTo(5299855);
    }

    @Test
    void resolve_part2_of_day15_problem() {
        //Given
        SensorAndBeaconPlan givenSensorAndBeaconPlan = SensorAndBeaconResolver.getSensorAndBeaconPlanFromLines(lines);

        //When
        long numberOfExcludedPositionsInARow = givenSensorAndBeaconPlan.computeTuningFrequency(4000000);

        //Then
        assertThat(numberOfExcludedPositionsInARow).isEqualTo(13615843289729L);
    }
}