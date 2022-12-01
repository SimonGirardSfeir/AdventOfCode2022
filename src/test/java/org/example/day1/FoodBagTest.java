package org.example.day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class FoodBagTest {

    private static Stream<Arguments> calories() {
        return Stream.of(
          Arguments.of(List.of(1000, 2000, 3000), 6000),
                Arguments.of(List.of(4000), 4000),
                Arguments.of(List.of(5000, 6000), 11000),
                Arguments.of(List.of(7000, 8000, 9000), 24000),
                Arguments.of(List.of(10000), 10000)
        );
    }

    @ParameterizedTest
    @MethodSource("calories")
    void getFootBagTotalCalories_with_given_calories_should_return_expected_calories(List<Integer> givenCalories, int totalCaloriesExpected) {
        //Given
        FoodBag foodBag = new FoodBag(givenCalories);
        //When
        int actualCalories = foodBag.getFootBagTotalCalories();
        //Then
        assertThat(actualCalories).isEqualTo(totalCaloriesExpected);
    }

}