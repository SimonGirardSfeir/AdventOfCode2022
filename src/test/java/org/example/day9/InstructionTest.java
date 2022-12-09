package org.example.day9;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionTest {

    private static Stream<Arguments> lineInputs() {
        return Stream.of(
                Arguments.of("R 4", new Instruction(Direction.RIGHT, 4)),
                Arguments.of("U 4", new Instruction(Direction.UP, 4)),
                Arguments.of("L 3", new Instruction(Direction.LEFT, 3)),
                Arguments.of("D 1", new Instruction(Direction.DOWN, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("lineInputs")
    void of_should_give_instruction_from_live(String givenLine, Instruction expectedInstruction) {
        //When
        Instruction instruction = Instruction.of(givenLine);

        //Then
        assertThat(instruction).isEqualTo(expectedInstruction);
    }
}