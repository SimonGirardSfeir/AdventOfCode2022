package org.example.day14;

import org.example.LineExtractor;
import org.example.day13.PacketsPairInventory;
import org.example.day13.PacketsPairResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CaveResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day14/inputData.txt");
    }

    @Test
    void resolve_part1_of_day14_problem() {
        //Given
        Cave givenCave = CaveResolver.getCaveFromLines(lines);

        //When
        int unitsOfSandResting = givenCave.countUnitsOfSandResting();

        //Then
        assertThat(unitsOfSandResting).isEqualTo(737);
    }

}