package org.example.day11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.day11.Operator.ADDITION;
import static org.example.day11.Operator.MULTIPLICATION;
import static org.example.day11.Operator.SQUARE;

class ZooTest {

    @Test
    void computeMonkeyBusiness_should_compute_expected_monkey_business_of_the_zoo_with_worrying_monkeys() {
        //Given
        Item item1 = new Item(79);
        Item item2 = new Item(98);
        List<Item> startingItems1 = new ArrayList<>();
        startingItems1.add(item1);
        startingItems1.add(item2);
        Operation operation1 = new Operation(19, MULTIPLICATION);
        Monkey givenMonkey1 = new NormalMonkey(0, startingItems1, operation1, 23,
                2, 3);
        Item item3 = new Item(54);
        Item item4 = new Item(65);
        Item item5 = new Item(75);
        Item item6 = new Item(74);
        List<Item> startingItems2 = new ArrayList<>();
        startingItems2.add(item3);
        startingItems2.add(item4);
        startingItems2.add(item5);
        startingItems2.add(item6);
        Operation operation2 = new Operation(6, ADDITION);
        Monkey givenMonkey2 = new NormalMonkey(1, startingItems2, operation2, 19,
                2, 0);
        Item item7 = new Item(79);
        Item item8 = new Item(60);
        Item item9 = new Item(97);
        List<Item> startingItems3 = new ArrayList<>();
        startingItems3.add(item7);
        startingItems3.add(item8);
        startingItems3.add(item9);
        Operation operation3 = new Operation(2, SQUARE);
        Monkey givenMonkey3 = new NormalMonkey(2, startingItems3, operation3, 13,
                1, 3);
        Item item10 = new Item(74);
        List<Item> startingItems4 = new ArrayList<>();
        startingItems4.add(item10);
        Operation operation4 = new Operation(3, ADDITION);
        Monkey givenMonkey4 = new NormalMonkey(3, startingItems4, operation4, 17,
                0, 1);
        Zoo givenZoo = new Zoo(List.of(givenMonkey1, givenMonkey2, givenMonkey3, givenMonkey4));

        //When
        long monkeyBusiness = givenZoo.computeMonkeyBusiness(20);

        //Then
        assertThat(monkeyBusiness).isEqualTo(10605L);
    }

    @Test
    void computeMonkeyBusiness_should_compute_expected_monkey_business_of_the_zoo_with_very_worrying_monkeys() {
        //Given
        Item item1 = new Item(79);
        Item item2 = new Item(98);
        List<Item> startingItems1 = new ArrayList<>();
        startingItems1.add(item1);
        startingItems1.add(item2);
        Operation operation1 = new Operation(19, MULTIPLICATION);
        Monkey givenMonkey1 = new WeirdMonkey(0, startingItems1, operation1, 23,
                2, 3);
        Item item3 = new Item(54);
        Item item4 = new Item(65);
        Item item5 = new Item(75);
        Item item6 = new Item(74);
        List<Item> startingItems2 = new ArrayList<>();
        startingItems2.add(item3);
        startingItems2.add(item4);
        startingItems2.add(item5);
        startingItems2.add(item6);
        Operation operation2 = new Operation(6, ADDITION);
        Monkey givenMonkey2 = new WeirdMonkey(1, startingItems2, operation2, 19,
                2, 0);
        Item item7 = new Item(79);
        Item item8 = new Item(60);
        Item item9 = new Item(97);
        List<Item> startingItems3 = new ArrayList<>();
        startingItems3.add(item7);
        startingItems3.add(item8);
        startingItems3.add(item9);
        Operation operation3 = new Operation(2, SQUARE);
        Monkey givenMonkey3 = new WeirdMonkey(2, startingItems3, operation3, 13,
                1, 3);
        Item item10 = new Item(74);
        List<Item> startingItems4 = new ArrayList<>();
        startingItems4.add(item10);
        Operation operation4 = new Operation(3, ADDITION);
        Monkey givenMonkey4 = new WeirdMonkey(3, startingItems4, operation4, 17,
                0, 1);
        Zoo givenZoo = new Zoo(List.of(givenMonkey1, givenMonkey2, givenMonkey3, givenMonkey4));

        //When
        long monkeyBusiness = givenZoo.computeMonkeyBusiness(10000);

        //Then
        assertThat(monkeyBusiness).isEqualTo(2713310158L);

    }

}