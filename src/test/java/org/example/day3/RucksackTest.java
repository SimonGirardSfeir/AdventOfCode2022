package org.example.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RucksackTest {

    @Test
    void of_should_give_a_rucksack_with_two_compartment_of_equal_length() {
        //Given
        String givenLine = "vJrwpWtwJgWrhcsFMMfFFhFp";

        //When
        Rucksack rucksack = Rucksack.of(givenLine);

        //Then
        Rucksack expectedRucksack = new Rucksack("vJrwpWtwJgWr","hcsFMMfFFhFp");
        assertThat(rucksack).isEqualTo(expectedRucksack);
    }

    private static Stream<Arguments> rucksacks() {
        return Stream.of(
                Arguments.of(Rucksack.of("vJrwpWtwJgWrhcsFMMfFFhFp"), 'p'),
                Arguments.of(Rucksack.of("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"), 'L'),
                Arguments.of(Rucksack.of("PmmdzqPrVvPwwTWBwg"), 'P'),
                Arguments.of(Rucksack.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"), 'v'),
                Arguments.of(Rucksack.of("ttgJtRGJQctTZtZT"), 't'),
                Arguments.of(Rucksack.of("CrZsJsPPZsGzwwsLwLmpwMDw"), 's')
        );
    }
    @ParameterizedTest
    @MethodSource("rucksacks")
    void getCommonItem_should_give_the_item_that_appears_in_both_rucksack_compartment(Rucksack givenRucksack, Character expectedCommonItem) {
        //When
        Character commonItem = givenRucksack.getCommonItem();

        //Then
        assertThat(commonItem).isEqualTo(expectedCommonItem);
    }

}