package org.example.day8;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ForestResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day8/inputData.txt");
    }

    @Test
    void resolve_part1_of_day8_problem() {
        //Given
        Forest givenForest = ForestResolver.getForestFromLines(lines);
        //When
        int numberOfVisibleTrees = givenForest.countVisibleTrees();
        //Then
        assertThat(numberOfVisibleTrees).isEqualTo(1854);
    }

    @Test
    void resolve_part2_of_day8_problem() {
        //Given
        Forest givenForest = ForestResolver.getForestFromLines(lines);
        //When
        int highestScenicScoreInForest = givenForest.getHighestScenicScoreInForest();
        //Then
        assertThat(highestScenicScoreInForest).isEqualTo(527340);
    }
}