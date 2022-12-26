package org.example.day15;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.common.PatternReference.NEW_LINE_PATTERN;

class SensorAndBeaconPlanTest {

    @Test
    void countExcludedPositionsInARow_should_give_number_of_excluded_position_for_any_beacon_in_a_row() {
        //Given
        String givenInput = """
                Sensor at x=2, y=18: closest beacon is at x=-2, y=15
                Sensor at x=9, y=16: closest beacon is at x=10, y=16
                Sensor at x=13, y=2: closest beacon is at x=15, y=3
                Sensor at x=12, y=14: closest beacon is at x=10, y=16
                Sensor at x=10, y=20: closest beacon is at x=10, y=16
                Sensor at x=14, y=17: closest beacon is at x=10, y=16
                Sensor at x=8, y=7: closest beacon is at x=2, y=10
                Sensor at x=2, y=0: closest beacon is at x=2, y=10
                Sensor at x=0, y=11: closest beacon is at x=2, y=10
                Sensor at x=20, y=14: closest beacon is at x=25, y=17
                Sensor at x=17, y=20: closest beacon is at x=21, y=22
                Sensor at x=16, y=7: closest beacon is at x=15, y=3
                Sensor at x=14, y=3: closest beacon is at x=15, y=3
                Sensor at x=20, y=1: closest beacon is at x=15, y=3""";
        SensorAndBeaconPlan givenSensorAndBeaconPlan = SensorAndBeaconResolver.getSensorAndBeaconPlanFromLines(
                Arrays.asList(NEW_LINE_PATTERN.split(givenInput)));

        //When
        int numberOfExcludedPositionsInARow = givenSensorAndBeaconPlan.countExcludedPositionsInARow(10);

        assertThat(numberOfExcludedPositionsInARow).isEqualTo(26);
    }

    @Test
    void computeTuningFrequency_should_tuning_frequency_of_undetected_distress_beacon() {
        //Given
        String givenInput = """
                Sensor at x=2, y=18: closest beacon is at x=-2, y=15
                Sensor at x=9, y=16: closest beacon is at x=10, y=16
                Sensor at x=13, y=2: closest beacon is at x=15, y=3
                Sensor at x=12, y=14: closest beacon is at x=10, y=16
                Sensor at x=10, y=20: closest beacon is at x=10, y=16
                Sensor at x=14, y=17: closest beacon is at x=10, y=16
                Sensor at x=8, y=7: closest beacon is at x=2, y=10
                Sensor at x=2, y=0: closest beacon is at x=2, y=10
                Sensor at x=0, y=11: closest beacon is at x=2, y=10
                Sensor at x=20, y=14: closest beacon is at x=25, y=17
                Sensor at x=17, y=20: closest beacon is at x=21, y=22
                Sensor at x=16, y=7: closest beacon is at x=15, y=3
                Sensor at x=14, y=3: closest beacon is at x=15, y=3
                Sensor at x=20, y=1: closest beacon is at x=15, y=3""";
        SensorAndBeaconPlan givenSensorAndBeaconPlan = SensorAndBeaconResolver.getSensorAndBeaconPlanFromLines(
                Arrays.asList(NEW_LINE_PATTERN.split(givenInput)));

        //When
        long numberOfExcludedPositionsInARow = givenSensorAndBeaconPlan.computeTuningFrequency(20);

        assertThat(numberOfExcludedPositionsInARow).isEqualTo(56000011L);
    }

}