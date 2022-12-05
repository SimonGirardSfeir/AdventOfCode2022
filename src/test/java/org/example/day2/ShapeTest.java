package org.example.day2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.day2.Outcome.DRAW;
import static org.example.day2.Outcome.LOSE;
import static org.example.day2.Outcome.WIN;

class ShapeTest {

    private static Stream<Arguments> opponentShapes() {
        return Stream.of(
                Arguments.of(Shape.PAPER, Shape.ROCK, WIN),
                Arguments.of(Shape.ROCK, Shape.PAPER, LOSE),
                Arguments.of(Shape.SCISSORS, Shape.SCISSORS, DRAW),
                Arguments.of(Shape.ROCK, Shape.ROCK, DRAW),
                Arguments.of(Shape.PAPER, Shape.PAPER, DRAW),
                Arguments.of(Shape.SCISSORS, Shape.ROCK, LOSE),
                Arguments.of(Shape.ROCK, Shape.SCISSORS, WIN),
                Arguments.of(Shape.PAPER, Shape.SCISSORS, LOSE),
                Arguments.of(Shape.SCISSORS, Shape.PAPER, WIN)
        );
    }
    @ParameterizedTest
    @MethodSource("opponentShapes")
    void getOutCome_should_give_correct_outcome_with_opponent_shape(Shape playerShape, Shape opponentShape, Outcome expectedOutcome) {
        Outcome outcome = playerShape.getOutcome(opponentShape);

        assertThat(outcome).isEqualTo(expectedOutcome);
    }

}