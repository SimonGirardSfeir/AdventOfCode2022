package org.example.day14;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RealisticCaveTest {

    @Test
    void countUnitsOfSandResting_with_realistic_cave_should_count_unit_of_sand_that_are_retained_by_rocks() {
        //Given
        String line1 = "498,4 -> 498,6 -> 496,6";
        String line2 = "503,4 -> 502,4 -> 502,9 -> 494,9";
        List<String> givenLines = List.of(line1, line2);
        Cave givenCave = CaveResolver.getRealisticCaveFromLines(givenLines);

        //When
        int unitsOfSandResting = givenCave.countUnitsOfSandResting();

        //Then
        assertThat(unitsOfSandResting).isEqualTo(93);
    }

}