package org.example.day1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public record Inventory(List<FoodBag> foodBags) {
    private static final long NUMBER_OF_FOOD_BAGS_TO_SELECT = 3L;
    public FoodBag getFoodBagWithMostCalories() {
        return Collections.max(foodBags, Comparator.comparing(FoodBag::getFootBagTotalCalories));
    }
    public List<FoodBag> getTop3FoodBagsWithMostCalories() {
        return foodBags.stream()
                .sorted(Comparator.comparing(FoodBag::getFootBagTotalCalories).reversed())
                .limit(NUMBER_OF_FOOD_BAGS_TO_SELECT)
                .toList();
    }
    public int computeTotalCaloriesFromTop3FoodBagsWithMostCalories() {
        return getTop3FoodBagsWithMostCalories().stream()
                .map(FoodBag::getFootBagTotalCalories)
                .reduce(0, Integer::sum);
    }
}
