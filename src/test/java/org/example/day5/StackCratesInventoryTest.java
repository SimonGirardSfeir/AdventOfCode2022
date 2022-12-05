package org.example.day5;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StackCratesInventoryTest {

    @Test
    void of_should_fill_stack_crates_inventory() {
        //Given
        String givenLine1 = "    [D]    ";
        String givenLine2 = "[N] [C]    ";
        String givenLine3 = "[Z] [M] [P]";
        List<String> givenLines = List.of(givenLine1, givenLine2, givenLine3);

        //When
        StackCratesInventory stackCratesInventory = StackCratesInventory.of(givenLines);

        //Then
        Deque<Character> deque1 = new ArrayDeque<>();
        deque1.push('Z');
        deque1.push('N');
        Deque<Character> deque2 = new ArrayDeque<>();
        deque2.push('M');
        deque2.push('C');
        deque2.push('D');
        Deque<Character> deque3 = new ArrayDeque<>();
        deque3.push('P');
        List<Deque<Character>> expectedStackCrates = List.of(deque1, deque2, deque3);
        StackCratesInventory expectedStackCratesInventory = new StackCratesInventory(expectedStackCrates);
        //Weird but comparing two ArrayDeque is not easy, because ArrayDeque does not have an over-ridden equals/hashCode method
        assertThat(stackCratesInventory.stackCrates().toArray()).usingRecursiveComparison()
                .isEqualTo(expectedStackCratesInventory.stackCrates().toArray());
    }
}