package org.example.day3;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RucksackResolverTest {
    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day3/inputData.txt");
    }

    @Test
    void resolve_part1_of_day3_problem() {
        //Given
        RucksackInventory rucksackInventory = RucksackResolver.getRuckSackInventoryFromLines(lines);

        //When
        int totalPriority = rucksackInventory.computeTotalPriority();

        //Then
        assertThat(totalPriority).isEqualTo(8233);
    }

    @Test
    void resolve_part2_of_day3_problem() {
        //Given
        RucksackInventory rucksackInventory = RucksackResolver.getRuckSackInventoryFromLines(lines);

        //When
        int totalPriority = rucksackInventory.computeTotalPriorityRucksacksGrouped(3);

        //Then
        assertThat(totalPriority).isEqualTo(2821);
    }
}