package org.example.day9;

import org.example.LineExtractor;
import org.example.day8.Forest;
import org.example.day8.ForestResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GroudResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day9/inputData.txt");
    }

    @Test
    void resolve_part1_of_day9_problem() {
        //Given
        List<Instruction> givenInstructions = GroudResolver.getInstructionFromLines(lines);
        Ground givenGround = new Ground(new Position(0,0), new Position(0,0));
        //When
        int numberOfPositionsVisitedByTail = givenGround.countPositionsVisited(givenInstructions);
        //Then
        assertThat(numberOfPositionsVisitedByTail).isEqualTo(6269);
    }

}