package org.example.day10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CPUTest {

    @Test
    void applyCPUInstructions_should_set_CPU_in_the_expected_state() {
        //Given
        CPUInstruction cpuInstruction1 = CPUInstruction.of("noop");
        CPUInstruction cpuInstruction2 = CPUInstruction.of("addx 3");
        CPUInstruction cpuInstruction3 = CPUInstruction.of("addx -5");
        List<CPUInstruction> givenCPUInstructions = List.of(cpuInstruction1, cpuInstruction2, cpuInstruction3);
        CPU givenCPU = new CPU();

        //When
        givenCPU.applyCPUInstructions(givenCPUInstructions);

        //Then
        Map<Integer, Integer> expectedRegisterHistory = new HashMap<>();
        expectedRegisterHistory.put(1,1);
        expectedRegisterHistory.put(2,1);
        expectedRegisterHistory.put(3,1);
        expectedRegisterHistory.put(4,4);
        expectedRegisterHistory.put(5,4);
        expectedRegisterHistory.put(6,-1);
        CPU expectedCPU = new CPU(-1, 6, expectedRegisterHistory);
        assertThat(givenCPU).isEqualTo(expectedCPU);
    }

    @Test
    void getSignalStrengthsSum_should_give_sum_of_given_signal_strength(){
        //Given
        String givenInput = """
                addx 15
                addx -11
                addx 6
                addx -3
                addx 5
                addx -1
                addx -8
                addx 13
                addx 4
                noop
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx -35
                addx 1
                addx 24
                addx -19
                addx 1
                addx 16
                addx -11
                noop
                noop
                addx 21
                addx -15
                noop
                noop
                addx -3
                addx 9
                addx 1
                addx -3
                addx 8
                addx 1
                addx 5
                noop
                noop
                noop
                noop
                noop
                addx -36
                noop
                addx 1
                addx 7
                noop
                noop
                noop
                addx 2
                addx 6
                noop
                noop
                noop
                noop
                noop
                addx 1
                noop
                noop
                addx 7
                addx 1
                noop
                addx -13
                addx 13
                addx 7
                noop
                addx 1
                addx -33
                noop
                noop
                noop
                addx 2
                noop
                noop
                noop
                addx 8
                noop
                addx -1
                addx 2
                addx 1
                noop
                addx 17
                addx -9
                addx 1
                addx 1
                addx -3
                addx 11
                noop
                noop
                addx 1
                noop
                addx 1
                noop
                noop
                addx -13
                addx -19
                addx 1
                addx 3
                addx 26
                addx -30
                addx 12
                addx -1
                addx 3
                addx 1
                noop
                noop
                noop
                addx -9
                addx 18
                addx 1
                addx 2
                noop
                noop
                addx 9
                noop
                noop
                noop
                addx -1
                addx 2
                addx -37
                addx 1
                addx 3
                noop
                addx 15
                addx -21
                addx 22
                addx -6
                addx 1
                noop
                addx 2
                addx 1
                noop
                addx -10
                noop
                noop
                addx 20
                addx 1
                addx 2
                addx 2
                addx -6
                addx -11
                noop
                noop
                noop""";
        List<CPUInstruction> givenCpuInstructions = CPUResolver.getCPUInstructionFromLines
                (Arrays.asList(givenInput.split("\\n")));
        CPU givenCpu = new CPU();
        givenCpu.applyCPUInstructions(givenCpuInstructions);

        //When
        int sumSignalStrength = givenCpu.computeSumSignalStrength(20, 40, 5);

        //Then
        assertThat(sumSignalStrength).isEqualTo(13140);
    }

    @Test
    void renderImage_should_give_expected_image(){
        //Given
        String givenInput = """
                addx 15
                addx -11
                addx 6
                addx -3
                addx 5
                addx -1
                addx -8
                addx 13
                addx 4
                noop
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx 5
                addx -1
                addx -35
                addx 1
                addx 24
                addx -19
                addx 1
                addx 16
                addx -11
                noop
                noop
                addx 21
                addx -15
                noop
                noop
                addx -3
                addx 9
                addx 1
                addx -3
                addx 8
                addx 1
                addx 5
                noop
                noop
                noop
                noop
                noop
                addx -36
                noop
                addx 1
                addx 7
                noop
                noop
                noop
                addx 2
                addx 6
                noop
                noop
                noop
                noop
                noop
                addx 1
                noop
                noop
                addx 7
                addx 1
                noop
                addx -13
                addx 13
                addx 7
                noop
                addx 1
                addx -33
                noop
                noop
                noop
                addx 2
                noop
                noop
                noop
                addx 8
                noop
                addx -1
                addx 2
                addx 1
                noop
                addx 17
                addx -9
                addx 1
                addx 1
                addx -3
                addx 11
                noop
                noop
                addx 1
                noop
                addx 1
                noop
                noop
                addx -13
                addx -19
                addx 1
                addx 3
                addx 26
                addx -30
                addx 12
                addx -1
                addx 3
                addx 1
                noop
                noop
                noop
                addx -9
                addx 18
                addx 1
                addx 2
                noop
                noop
                addx 9
                noop
                noop
                noop
                addx -1
                addx 2
                addx -37
                addx 1
                addx 3
                noop
                addx 15
                addx -21
                addx 22
                addx -6
                addx 1
                noop
                addx 2
                addx 1
                noop
                addx -10
                noop
                noop
                addx 20
                addx 1
                addx 2
                addx 2
                addx -6
                addx -11
                noop
                noop
                noop""";
        List<CPUInstruction> givenCpuInstructions = CPUResolver.getCPUInstructionFromLines
                (Arrays.asList(givenInput.split("\\n")));
        CPU givenCpu = new CPU();

        //When
        List<String> image = givenCpu.renderImage(givenCpuInstructions);

        //Then
        String row1 = "##..##..##..##..##..##..##..##..##..##..";
        String row2 = "###...###...###...###...###...###...###.";
        String row3 = "####....####....####....####....####....";
        String row4 = "#####.....#####.....#####.....#####.....";
        String row5 = "######......######......######......####";
        String row6 = "#######.......#######.......#######.....";
        List<String> expectedImage = List.of(row1, row2, row3, row4, row5, row6);
        assertThat(image).isEqualTo(expectedImage);
    }

}