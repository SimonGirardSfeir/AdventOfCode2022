package org.example.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SectionTest {

    private static Stream<Arguments> inputStrings() {
        return Stream.of(
            Arguments.of(new Integer[]{2,4}, new Section(2,4)),
            Arguments.of(new Integer[]{6,8}, new Section(6,8))
        );
    }
    @ParameterizedTest
    @MethodSource("inputStrings")
    void of_should_give_section_from_input_string(Integer[] givenInput, Section expectedSection) {
        //When
        Section section = Section.of(givenInput);

        //Then
        assertThat(section).isEqualTo(expectedSection);
    }

}