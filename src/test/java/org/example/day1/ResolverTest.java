package org.example.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResolverTest {
    private List<String> listPart1;
    private List<String> listPart2;

    @BeforeEach
    void setUp() throws IOException {
        listPart1 = Resolver.getLines("src/test/resources/day1/part1.txt");
        listPart2 = Resolver.getLines("src/test/resources/day1/part2.txt");
    }

    @Test
    void resolve_part1_of_day1_problem() {
        Inventory inventory = Resolver.inventoryFromLine(listPart1);
        FoodBag foodBagWithMostCalories = inventory.getFoodBagWithMostCalories();
        int topCalories = foodBagWithMostCalories.getFootBagTotalCalories();

        assertThat(topCalories).isEqualTo(74198);
    }

    @Test
    void resolve_part2_of_day1_problem() {
        Inventory inventory = Resolver.inventoryFromLine(listPart2);
        List<FoodBag> top3foodBagWithMostCalories = inventory.getTop3FoodBagsWithMostCalories();
        int totalCaloriesTop3 = top3foodBagWithMostCalories.stream()
                .map(FoodBag::getFootBagTotalCalories)
                .reduce(0, Integer::sum);

        assertThat(totalCaloriesTop3).isEqualTo(209914);
    }
}