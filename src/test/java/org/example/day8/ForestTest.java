package org.example.day8;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ForestTest {

    @Test
    void countVisibleTrees_should_count_the_number_of_trees_visible_in_the_forest() {
        //Given
        String line1 = "30373";
        String line2 = "25512";
        String line3 = "65332";
        String line4 = "33549";
        String line5 = "35390";
        List<String> lines = List.of(line1, line2, line3, line4, line5);
        Forest givenForest = ForestResolver.getForestFromLines(lines);

        //When
        int numberOfVisibleTrees = givenForest.countVisibleTrees();

        //Then
        assertThat(numberOfVisibleTrees).isEqualTo(21);
    }

    @Test
    void getHighestScenicScoreInForest_should_count_the_number_of_trees_visible_in_the_forest() {
        //Given
        String line1 = "30373";
        String line2 = "25512";
        String line3 = "65332";
        String line4 = "33549";
        String line5 = "35390";
        List<String> lines = List.of(line1, line2, line3, line4, line5);
        Forest givenForest = ForestResolver.getForestFromLines(lines);

        //When
        int numberOfVisibleTrees = givenForest.getHighestScenicScoreInForest();

        //Then
        assertThat(numberOfVisibleTrees).isEqualTo(8);
    }

}