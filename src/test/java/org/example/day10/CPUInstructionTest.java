package org.example.day10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.day10.InstructionType.ADDX;
import static org.example.day10.InstructionType.NOOP;

class CPUInstructionTest {

    private static Stream<Arguments> lines() {
        return Stream.of(
                Arguments.of("noop", new CPUInstruction(NOOP, 0)),
                Arguments.of("addx 3", new CPUInstruction(ADDX, 3)),
                Arguments.of("addx -5", new CPUInstruction(ADDX, -5))
        );
    }

    @ParameterizedTest
    @MethodSource("lines")
    void of_should_give_expected_CPU_Instruction(String givenLine, CPUInstruction expectedCPUInstruction) {
        //When
        CPUInstruction cpuInstruction = CPUInstruction.of(givenLine);

        //Then
        assertThat(cpuInstruction).isEqualTo(expectedCPUInstruction);
    }

}