package org.example.day6;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MarkerResolverTest {

    private String line;

    @BeforeEach
    void setUp() throws IOException {
        line = LineExtractor.getLines("src/test/resources/day6/inputData.txt").get(0);
    }

    private static Stream<Arguments> datastreamBuffersPart1() {
        return Stream.of(
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 5),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 6),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 10),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 11)
        );
    }
    @ParameterizedTest
    @MethodSource("datastreamBuffersPart1")
    void getFirstMarker_should_give_the_number_of_character_processed_after_first_marker_is_completed_markerLength_of_4
            (String givenDatastreamBuffer, int expectedFirstMarker) {
        //When
        int firstMarker = MarkerResolver.getFirstMarker(givenDatastreamBuffer, 4);

        //Then
        assertThat(firstMarker).isEqualTo(expectedFirstMarker);
    }

    @Test
    void resolve_part1_of_day6_problem() {
        //When
        int firstMarker = MarkerResolver.getFirstMarker(line, 4);
        //Then
        assertThat(firstMarker).isEqualTo(1100);
    }

    private static Stream<Arguments> datastreamBuffersPart2() {
        return Stream.of(
                Arguments.of("mjqjpqmgbljsphdztnvjfqwrcgsmlb", 19),
                Arguments.of("bvwbjplbgvbhsrlpgdmjqwftvncz", 23),
                Arguments.of("nppdvjthqldpwncqszvftbrmjlhg", 23),
                Arguments.of("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 29),
                Arguments.of("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 26)
        );
    }
    @ParameterizedTest
    @MethodSource("datastreamBuffersPart2")
    void getFirstMarker_should_give_the_number_of_character_processed_after_first_marker_is_completed_markerLength_of_14
            (String givenDatastreamBuffer, int expectedFirstMarker) {
        //When
        int firstMarker = MarkerResolver.getFirstMarker(givenDatastreamBuffer, 14);

        //Then
        assertThat(firstMarker).isEqualTo(expectedFirstMarker);
    }

    @Test
    void resolve_part2_of_day6_problem() {
        //When
        int firstMarker = MarkerResolver.getFirstMarker(line, 14);
        //Then
        assertThat(firstMarker).isEqualTo(2421);
    }

}