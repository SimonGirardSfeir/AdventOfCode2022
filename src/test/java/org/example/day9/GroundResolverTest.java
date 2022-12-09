package org.example.day9;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GroundResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day9/inputData.txt");
    }

    @Test
    void resolve_part1_of_day9_problem() {
        //Given
        List<Instruction> givenInstructions = GroundResolver.getInstructionFromLines(lines);
        Ground givenGround = new Ground(1);
        //When
        int numberOfPositionsVisitedByTail = givenGround.countPositionsVisited(givenInstructions);
        //Then
        assertThat(numberOfPositionsVisitedByTail).isEqualTo(6269);
    }

    @Test
    void resolve_part2_of_day9_problem() {
        //Given
        List<Instruction> givenInstructions = GroundResolver.getInstructionFromLines(lines);
        Ground givenGround = new Ground(9);
        //When
        int numberOfPositionsVisitedByTail = givenGround.countPositionsVisited(givenInstructions);
        //Then
        assertThat(numberOfPositionsVisitedByTail).isEqualTo(2557);
    }

}