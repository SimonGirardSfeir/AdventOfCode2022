package org.example.day5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionPerformerReverseOrderTest {

    private final InstructionPerformer instructionPerformer = new InstructionPerformerReverseOrder();

    @Test
    void applyInstructions_should_apply_instruction_to_stack_inventory_rightFully_and_send_Message() {
        //Given
        String givenLine1 = "    [D]    ";
        String givenLine2 = "[N] [C]    ";
        String givenLine3 = "[Z] [M] [P]";
        List<String> givenLines = List.of(givenLine1, givenLine2, givenLine3);
        StackCratesInventory givenStackCratesInventory = StackCratesResolver.generateStackCratesInventory(givenLines);
        Instruction instruction1 = StackCratesResolver.getInstructionFromLine("move 1 from 2 to 1");
        Instruction instruction2 = StackCratesResolver.getInstructionFromLine("move 3 from 1 to 3");
        Instruction instruction3 = StackCratesResolver.getInstructionFromLine("move 2 from 2 to 1");
        Instruction instruction4 = StackCratesResolver.getInstructionFromLine("move 1 from 1 to 2");
        List<Instruction> givenInstructions = List.of(instruction1, instruction2, instruction3, instruction4);

        //When
        String message = instructionPerformer.applyInstructions(givenStackCratesInventory, givenInstructions);

        //Then
        String expectedMessage = "CMZ";
        assertThat(message).isEqualTo(expectedMessage);
    }

}