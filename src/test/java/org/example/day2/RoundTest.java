package org.example.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    private static Stream<Arguments> inputRound() {
        return Stream.of(
                Arguments.of(new Round(Shape.PAPER, Shape.ROCK), 8),
                Arguments.of(new Round(Shape.ROCK, Shape.PAPER), 1),
                Arguments.of(new Round(Shape.SCISSORS, Shape.SCISSORS), 6),
                Arguments.of(new Round(Shape.ROCK, Shape.ROCK), 4),
                Arguments.of(new Round(Shape.PAPER, Shape.PAPER), 5),
                Arguments.of(new Round(Shape.SCISSORS, Shape.ROCK), 3),
                Arguments.of(new Round(Shape.ROCK, Shape.SCISSORS), 7),
                Arguments.of(new Round(Shape.PAPER, Shape.SCISSORS), 2),
                Arguments.of(new Round(Shape.SCISSORS, Shape.PAPER), 9)
        );
    }
    @ParameterizedTest
    @MethodSource("inputRound")
    void computeScore_should_give_player_score_for_the_round(Round givenRound, int expectedScore) {
        //When
        int score = givenRound.computeScore();

        assertThat(score).isEqualTo(expectedScore);
    }

}