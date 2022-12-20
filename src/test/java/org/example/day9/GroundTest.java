package org.example.day9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GroundTest {

    private static Stream<Arguments> setOfInstructions(){
        Instruction instruction1 = new Instruction(Direction.RIGHT, 4);
        Instruction instruction2 = new Instruction(Direction.UP, 4);
        Instruction instruction3 = new Instruction(Direction.LEFT, 3);
        Instruction instruction4 = new Instruction(Direction.DOWN, 1);
        Instruction instruction5 = new Instruction(Direction.RIGHT, 4);
        Instruction instruction6 = new Instruction(Direction.DOWN, 1);
        Instruction instruction7 = new Instruction(Direction.LEFT, 5);
        Instruction instruction8 = new Instruction(Direction.RIGHT, 2);
        List<Instruction> givenInstructions1 = List.of(instruction1, instruction2, instruction3, instruction4,
                instruction5, instruction6, instruction7, instruction8);
        Instruction instruction9 = new Instruction(Direction.RIGHT, 5);
        Instruction instruction10 = new Instruction(Direction.UP, 8);
        Instruction instruction11 = new Instruction(Direction.LEFT, 8);
        Instruction instruction12 = new Instruction(Direction.DOWN, 3);
        Instruction instruction13 = new Instruction(Direction.RIGHT, 17);
        Instruction instruction14 = new Instruction(Direction.DOWN, 10);
        Instruction instruction15 = new Instruction(Direction.LEFT, 25);
        Instruction instruction16 = new Instruction(Direction.UP, 20);
        List<Instruction> givenInstructions2 = List.of(instruction9, instruction10, instruction11, instruction12,
                instruction13, instruction14, instruction15, instruction16);
        return Stream.of(
                Arguments.of(givenInstructions1, 1,  13),
                Arguments.of(givenInstructions1, 9,  1),
                Arguments.of(givenInstructions2, 9, 36)
        );
    }

    @ParameterizedTest
    @MethodSource("setOfInstructions")
    void countPositionsVisited_should_give_the_number_of_different_position_visited_by_tail_case_rope_of_size_9(
            List<Instruction> givenInstructions, int givenRopeSize, int expectedNumberOfPositionsVisited
    ) {
        //Given
        Ground givenGround = new Ground(givenRopeSize);

        //When
        int numberOfPositionsVisited = givenGround.countPositionsVisited(givenInstructions);

        //Then
        assertThat(numberOfPositionsVisited).isEqualTo(expectedNumberOfPositionsVisited);
    }

}