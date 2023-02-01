package org.example.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlanTest {
    @Test
    void findPathLength_shoud_give_the_length_of_the_shortest_path_from_start_to_end_if_end_is_unique() {
        //Given
        String line1 = "Sabqponm";
        String line2 = "abcryxxl";
        String line3 = "accszExk";
        String line4 = "acctuvwj";
        String line5 = "abdefghi";
        List<String> givenLines = List.of(line1, line2, line3, line4, line5);
        Plan givenPlan = PlanResolver.getPlanFromLines(givenLines, false);

        //When
        int pathLength = givenPlan.findPathLengthForUniqueSource('S', 'E');

        //Then
        assertThat(pathLength).isEqualTo(31);
    }

    @Test
    void findPathLength_shoud_give_the_length_of_the_shortest_path_from_start_to_end_if_source_is_not_unique() {
        //Given
        String line1 = "Sabqponm";
        String line2 = "abcryxxl";
        String line3 = "accszExk";
        String line4 = "acctuvwj";
        String line5 = "abdefghi";
        List<String> givenLines = List.of(line1, line2, line3, line4, line5);
        Plan givenPlan = PlanResolver.getPlanFromLines(givenLines, true);

        //When
        int pathLength = givenPlan.findPathLengthForMultipleSource('a', 'E');

        //Then
        assertThat(pathLength).isEqualTo(29);
    }
}