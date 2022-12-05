package org.example.day5;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StackCratesResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day5/inputData.txt");
    }

    @Test
    void resolve_part1_of_day5_problem() {
        //Given
        StackCratesInventory givenStackCratesInventory = StackCratesResolver.getStackCratesInventoryFromLines(lines);
        List<Instruction> givenInstructions = StackCratesResolver.getInstructionsFromLines(lines);
        InstructionPerformer givenInstructionPerformer = new InstructionPerformerReverseOrder();

        //When
        String message = givenInstructionPerformer.applyInstructions(givenStackCratesInventory, givenInstructions);

        //Then
        assertThat(message).isEqualTo("NTWZZWHFV");
    }

    @Test
    void resolve_part2_of_day5_problem() {
        //Given
        StackCratesInventory givenStackCratesInventory = StackCratesResolver.getStackCratesInventoryFromLines(lines);
        List<Instruction> givenInstructions = StackCratesResolver.getInstructionsFromLines(lines);
        InstructionPerformer givenInstructionPerformer = new InstructionPerformerClassicOrder();

        //When
        String message = givenInstructionPerformer.applyInstructions(givenStackCratesInventory, givenInstructions);

        //Then
        assertThat(message).isEqualTo("BRZGFVBTJ");

    }

}