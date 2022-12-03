package org.example.day3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RucksackInventoryTest {

    @Test
    void computeTotalPriority_should_give_total_priority_of_rucksacks_inventory() {
        //Given
        Rucksack rucksack1 = Rucksack.of("vJrwpWtwJgWrhcsFMMfFFhFp");
        Rucksack rucksack2 = Rucksack.of("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        Rucksack rucksack3 = Rucksack.of("PmmdzqPrVvPwwTWBwg");
        Rucksack rucksack4 = Rucksack.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        Rucksack rucksack5 = Rucksack.of("ttgJtRGJQctTZtZT");
        Rucksack rucksack6 = Rucksack.of("CrZsJsPPZsGzwwsLwLmpwMDw");
        List<Rucksack> rucksacks = List.of(rucksack1, rucksack2, rucksack3, rucksack4, rucksack5, rucksack6);
        RucksackInventory rucksackInventory = new RucksackInventory(rucksacks);

        //When
        int totalPriority = rucksackInventory.computeTotalPriority();

        //Then
        assertThat(totalPriority).isEqualTo(157);
    }

    @Test
    void computeTotalPriorityRucksacksGrouped_should_give_total_priority_of_rucksacks_inventory_grouped() {
        //Given
        Rucksack rucksack1 = Rucksack.of("vJrwpWtwJgWrhcsFMMfFFhFp");
        Rucksack rucksack2 = Rucksack.of("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        Rucksack rucksack3 = Rucksack.of("PmmdzqPrVvPwwTWBwg");
        Rucksack rucksack4 = Rucksack.of("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        Rucksack rucksack5 = Rucksack.of("ttgJtRGJQctTZtZT");
        Rucksack rucksack6 = Rucksack.of("CrZsJsPPZsGzwwsLwLmpwMDw");
        List<Rucksack> rucksacks = List.of(rucksack1, rucksack2, rucksack3, rucksack4, rucksack5, rucksack6);
        RucksackInventory rucksackInventory = new RucksackInventory(rucksacks);

        //When
        int totalPriority = rucksackInventory.computeTotalPriorityRucksacksGrouped(3);

        //Then
        assertThat(totalPriority).isEqualTo(70);
    }

}