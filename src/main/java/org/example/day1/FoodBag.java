package org.example.day1;

import java.util.List;

public record FoodBag(List<Integer> calories) {
    public Integer getFootBagTotalCalories() {
        return calories.stream().reduce(0, Integer::sum);
    }
}
