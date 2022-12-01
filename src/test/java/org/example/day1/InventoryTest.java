package org.example.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InventoryTest {
    @Test
    void getFoodBagWithMostCalories_should_return_FoodBag_with_most_calories() {
        //Given
        FoodBag foodBag1 = new FoodBag(List.of(1000, 2000, 3000));
        FoodBag foodBag2 = new FoodBag(List.of(4000));
        FoodBag foodBag3 = new FoodBag(List.of(5000, 6000));
        FoodBag foodBag4 = new FoodBag(List.of(7000, 8000, 9000));
        FoodBag foodBag5 = new FoodBag(List.of(10000));
        List<FoodBag> foodBags = List.of(foodBag1, foodBag2, foodBag3, foodBag4, foodBag5);
        Inventory givenInventory = new Inventory(foodBags);

        //When
        FoodBag actualFoodBag = givenInventory.getFoodBagWithMostCalories();

        //Then
        assertThat(actualFoodBag).isEqualTo(foodBag4);
    }

    @Test
    void getTop3FoodBagsWithMostCalories_should_return_top3_FoodBag_with_most_calories() {
        //Given
        FoodBag foodBag1 = new FoodBag(List.of(1000, 2000, 3000));
        FoodBag foodBag2 = new FoodBag(List.of(4000));
        FoodBag foodBag3 = new FoodBag(List.of(5000, 6000));
        FoodBag foodBag4 = new FoodBag(List.of(7000, 8000, 9000));
        FoodBag foodBag5 = new FoodBag(List.of(10000));
        List<FoodBag> foodBags = List.of(foodBag1, foodBag2, foodBag3, foodBag4, foodBag5);
        Inventory givenInventory = new Inventory(foodBags);

        //When
        List<FoodBag> actualFoodBags = givenInventory.getTop3FoodBagsWithMostCalories();

        //Then
        List<FoodBag> expectedFoodBags = List.of(foodBag3, foodBag4, foodBag5);
        assertThat(actualFoodBags).hasSameElementsAs(expectedFoodBags);
    }
}