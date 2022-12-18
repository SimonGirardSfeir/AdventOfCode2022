package org.example.day14;

import org.example.common.Position;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CaveTest {

    @Test
    void of_should_give_cave_rocks_at_expected_places() {
        //Given
        String line1 = "498,4 -> 498,6 -> 496,6";
        String line2 = "503,4 -> 502,4 -> 502,9 -> 494,9";
        List<String> givenLines = List.of(line1, line2);

        //When
        Cave cave = Cave.of(givenLines);

        //Then
        Set<Position> sands = new HashSet<>();
        Position position1 = new Position(498, 4);
        Position position2 = new Position(498, 5);
        Position position3 = new Position(498, 6);
        Position position4 = new Position(497, 6);
        Position position5 = new Position(496, 6);
        Position position6 = new Position(503, 4);
        Position position7 = new Position(502, 4);
        Position position8 = new Position(502, 5);
        Position position9 = new Position(502, 6);
        Position position10 = new Position(502, 7);
        Position position11 = new Position(502, 8);
        Position position12 = new Position(502, 9);
        Position position13 = new Position(501, 9);
        Position position14 = new Position(500, 9);
        Position position15 = new Position(499, 9);
        Position position16 = new Position(498, 9);
        Position position17 = new Position(497, 9);
        Position position18 = new Position(496, 9);
        Position position19 = new Position(495, 9);
        Position position20 = new Position(494, 9);
        Set<Position> rocks = Set.of(position1, position2, position3, position4, position5, position6, position7, position8,
                position9, position10, position11, position12, position13, position14, position15, position16, position17,
                position18, position19, position20);
        Cave expectedCave = new Cave(rocks, sands, 9, 494, 503);
        assertThat(cave).isEqualTo(expectedCave);
    }

    @Test
    void countUnitsOfSandResting_should_count_unit_of_sand_that_are_retained_by_rocks() {
        //Given
        String line1 = "498,4 -> 498,6 -> 496,6";
        String line2 = "503,4 -> 502,4 -> 502,9 -> 494,9";
        List<String> givenLines = List.of(line1, line2);
        Cave givenCave = Cave.of(givenLines);

        //When
        int unitsOfSandResting = givenCave.countUnitsOfSandResting();

        //Then
        assertThat(unitsOfSandResting).isEqualTo(24);
    }
}