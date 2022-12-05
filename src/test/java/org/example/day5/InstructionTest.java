package org.example.day5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionTest {

    private static Stream<Arguments> givenLines(){
        return Stream.of(
                Arguments.of("move 1 from 2 to 1", new Instruction(1, 2, 1)),
                Arguments.of("move 3 from 1 to 3", new Instruction(3, 1, 3)),
                Arguments.of("move 2 from 2 to 1", new Instruction(2, 2, 1)),
                Arguments.of("move 1 from 1 to 2", new Instruction(1, 1, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("givenLines")
    void of_should_give_instruction(String givenLine, Instruction expectedInstruction) {
        //When
        Instruction instruction = Instruction.of(givenLine);

        //Then
        assertThat(instruction).isEqualTo(expectedInstruction);
    }

}