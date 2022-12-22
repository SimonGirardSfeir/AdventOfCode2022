package org.example.day11;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ZooResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day11/inputData.txt");
    }

    @Test
    void resolve_part1_of_day11_problem() {
        //Given
        Zoo givenZoo = ZooResolver.getMonkeysZooFromLines(lines, false);

        //When
        long monkeyBusiness = givenZoo.computeMonkeyBusiness(20);

        //Then
        assertThat(monkeyBusiness).isEqualTo(76728L);
    }

    @Test
    void resolve_part2_of_day11_problem() {
        //Given
        Zoo givenZoo = ZooResolver.getMonkeysZooFromLines(lines, true);

        //When
        long monkeyBusiness = givenZoo.computeMonkeyBusiness(10000);

        //Then
        assertThat(monkeyBusiness).isEqualTo(21553910156L);
    }

}