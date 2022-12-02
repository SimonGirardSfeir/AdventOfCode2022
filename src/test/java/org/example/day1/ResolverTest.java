package org.example.day1;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResolverTest {
    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day1/inputData.txt");
    }

    @Test
    void resolve_part1_of_day1_problem() {
        Inventory inventory = Resolver.inventoryFromLine(lines);
        FoodBag foodBagWithMostCalories = inventory.getFoodBagWithMostCalories();
        int topCalories = foodBagWithMostCalories.getFootBagTotalCalories();

        assertThat(topCalories).isEqualTo(74198);
    }

    @Test
    void resolve_part2_of_day1_problem() {
        Inventory inventory = Resolver.inventoryFromLine(lines);
        List<FoodBag> top3foodBagWithMostCalories = inventory.getTop3FoodBagsWithMostCalories();
        int totalCaloriesTop3 = top3foodBagWithMostCalories.stream()
                .map(FoodBag::getFootBagTotalCalories)
                .reduce(0, Integer::sum);

        assertThat(totalCaloriesTop3).isEqualTo(209914);
    }
}