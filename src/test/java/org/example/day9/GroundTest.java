package org.example.day9;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GroundTest {

    @Test
    void moveElements_should_move_head_and_tail_in_right_places() {
        //Given
        Instruction instruction1 = Instruction.of("R 4");
        Instruction instruction2 = Instruction.of("U 4");
        Instruction instruction3 = Instruction.of("L 3");
        Instruction instruction4 = Instruction.of("D 1");
        Instruction instruction5 = Instruction.of("R 4");
        Instruction instruction6 = Instruction.of("D 1");
        Instruction instruction7 = Instruction.of("L 5");
        Instruction instruction8 = Instruction.of("R 2");
        List<Instruction> givenInstructions = List.of(instruction1, instruction2, instruction3, instruction4,
                instruction5, instruction6, instruction7, instruction8);
        Ground givenGround = new Ground(new Position(0,0), new Position(0,0));

        //When
        givenGround.moveElements(givenInstructions);

        //Then
        assertThat(givenGround.head()).isEqualTo(new Position(2, 2));
        assertThat(givenGround.tail()).isEqualTo(new Position(1, 2));
    }

    @Test
    void countPositionsVisited_should_give_the_number_of_different_position_visited() {
        //Given
        Instruction instruction1 = Instruction.of("R 4");
        Instruction instruction2 = Instruction.of("U 4");
        Instruction instruction3 = Instruction.of("L 3");
        Instruction instruction4 = Instruction.of("D 1");
        Instruction instruction5 = Instruction.of("R 4");
        Instruction instruction6 = Instruction.of("D 1");
        Instruction instruction7 = Instruction.of("L 5");
        Instruction instruction8 = Instruction.of("R 2");
        List<Instruction> givenInstructions = List.of(instruction1, instruction2, instruction3, instruction4,
                instruction5, instruction6, instruction7, instruction8);
        Ground givenGround = new Ground(new Position(0,0), new Position(0,0));

        //When
        int numberOfPositionsVisited = givenGround.countPositionsVisited(givenInstructions);

        //Then
        assertThat(numberOfPositionsVisited).isEqualTo(13);
    }

}