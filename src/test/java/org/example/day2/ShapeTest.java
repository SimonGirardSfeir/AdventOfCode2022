package org.example.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeTest {

    private static Stream<Arguments> opponentShapes() {
        return Stream.of(
                Arguments.of(Shape.PAPER, Shape.ROCK, 6),
                Arguments.of(Shape.ROCK, Shape.PAPER, 0),
                Arguments.of(Shape.SCISSORS, Shape.SCISSORS, 3),
                Arguments.of(Shape.ROCK, Shape.ROCK, 3),
                Arguments.of(Shape.PAPER, Shape.PAPER, 3),
                Arguments.of(Shape.SCISSORS, Shape.ROCK, 0),
                Arguments.of(Shape.ROCK, Shape.SCISSORS, 6),
                Arguments.of(Shape.PAPER, Shape.SCISSORS, 0),
                Arguments.of(Shape.SCISSORS, Shape.PAPER, 6)
        );
    }
    @ParameterizedTest
    @MethodSource("opponentShapes")
    void getOutCome_should_give_correct_outcome_with_opponent_shape(Shape playerShape, Shape opponentShape, int expectedOutcome) {
        int outcome = playerShape.getOutCome(opponentShape);

        assertThat(outcome).isEqualTo(expectedOutcome);
    }

}