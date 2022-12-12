package org.example.day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    private static Stream<Arguments> startingItems() {
        return Stream.of(
                Arguments.of("  Starting items: 79, 98", List.of(new Item(79L), new Item(98L))),
                Arguments.of("  Starting items: 54, 65, 75, 74", List.of(new Item(54L), new Item(65L),
                        new Item(75L), new Item(74L))),
                Arguments.of("  Starting items: 79, 60, 97", List.of(new Item(79L), new Item(60L),
                        new Item(97L)))
                );
    }

    @ParameterizedTest
    @MethodSource("startingItems")
    void of_should_given_items_from_starting_items_line(String givenStartingItemLine, List<Item> expectedItems) {
        //When
        List<Item> items = Item.of(givenStartingItemLine);

        //Then
        assertThat(items).isEqualTo(expectedItems);
    }

}