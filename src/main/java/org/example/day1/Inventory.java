package org.example.day1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public record Inventory(List<FoodBag> foodBags) {
    public FoodBag getFoodBagWithMostCalories() {
        return Collections.max(foodBags, Comparator.comparing(FoodBag::getFootBagTotalCalories));
    }

    public List<FoodBag> getTop3FoodBagsWithMostCalories() {
        return foodBags.stream()
                .sorted(Comparator.comparing(FoodBag::getFootBagTotalCalories).reversed())
                .limit(3)
                .toList();
    }
}
