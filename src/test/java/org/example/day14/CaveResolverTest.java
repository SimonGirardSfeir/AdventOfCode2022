package org.example.day14;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CaveResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day14/inputData.txt");
    }

    @Test
    void resolve_part1_of_day14_problem() {
        //Given
        Cave givenCave = CaveResolver.getUnrealisticCaveFromLines(lines);

        //When
        int unitsOfSandResting = givenCave.countUnitsOfSandResting();

        //Then
        assertThat(unitsOfSandResting).isEqualTo(737);
    }

    @Test
    void resolve_part2_of_day14_problem() {
        //Given
        Cave givenCave = CaveResolver.getRealisticCaveFromLines(lines);

        //When
        int unitsOfSandResting = givenCave.countUnitsOfSandResting();

        //Then
        assertThat(unitsOfSandResting).isEqualTo(28145);
    }

}