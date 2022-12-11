package org.example.day10;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CPUResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day10/inputData.txt");
    }

    @Test
    void resolve_part1_of_day10_problem() {
        //Given
        List<CPUInstruction> givenInstructions = CPUResolver.getCPUInstructionFromLines(lines);
        CPU givenCpu = new CPU();
        givenCpu.applyCPUInstructions(givenInstructions);

        //When
        int sumSignalStrength = givenCpu.computeSumSignalStrength(20, 40, 5);

        //Then
        assertThat(sumSignalStrength).isEqualTo(13860);
    }

    @Test
    void resolve_part2_of_day10_problem() {
        //Given
        List<CPUInstruction> givenInstructions = CPUResolver.getCPUInstructionFromLines(lines);
        CPU givenCpu = new CPU();

        //When
        List<String> image = givenCpu.renderImage(givenInstructions);

        //Then
        String row1 = "###..####.#..#.####..##....##..##..###..";
        String row2 = "#..#....#.#..#.#....#..#....#.#..#.#..#.";
        String row3 = "#..#...#..####.###..#.......#.#....###..";
        String row4 = "###...#...#..#.#....#.##....#.#....#..#.";
        String row5 = "#.#..#....#..#.#....#..#.#..#.#..#.#..#.";
        String row6 = "#..#.####.#..#.#.....###..##...##..###..";
        List<String> expectedImage = List.of(row1, row2, row3, row4, row5, row6);
        assertThat(image).isEqualTo(expectedImage);
    }

}