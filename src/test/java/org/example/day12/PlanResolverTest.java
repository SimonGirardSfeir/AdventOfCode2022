package org.example.day12;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlanResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day12/inputData.txt");
    }

    @Test
    void resolve_part1_of_day12_problem() {
        //Given
        Plan givenPlan = PlanResolver.getPlanFromLines(lines, false);

        //When
        int shortestPath = givenPlan.findPathLengthForUniqueSource('S', 'E');

        //Then
        assertThat(shortestPath).isEqualTo(350);
    }

    @Test
    void resolve_part2_of_day12_problem() {
        //Given
        Plan givenPlan = PlanResolver.getPlanFromLines(lines, true);

        //When
        int shortestPath = givenPlan.findPathLengthForMultipleSource('a', 'E');

        //Then
        assertThat(shortestPath).isEqualTo(349);
    }

}