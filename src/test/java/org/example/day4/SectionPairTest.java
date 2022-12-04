package org.example.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SectionPairTest {

    private static Stream<Arguments> inputStrings() {
        return Stream.of(
                Arguments.of("2-4,6-8", new SectionPair(Section.of("2-4"),Section.of("6-8"))),
                Arguments.of("2-3,4-5", new SectionPair(Section.of("2-3"),Section.of("4-5")))
        );
    }
    @ParameterizedTest
    @MethodSource("inputStrings")
    void of_should_give_section_pair_from_input_string(String givenInput, SectionPair expectedSectionPair) {
        //When
        SectionPair section = SectionPair.of(givenInput);

        //Then
        assertThat(section).isEqualTo(expectedSectionPair);
    }

    private static Stream<Arguments> inputSectionPairs() {
        return Stream.of(
                Arguments.of(SectionPair.of("2-8,3-7"),true),
                Arguments.of(SectionPair.of("6-6,4-6"),true),
                Arguments.of(SectionPair.of("2-4,6-8"),false)
        );
    }
    @ParameterizedTest
    @MethodSource("inputSectionPairs")
    void isOneSectionFullyContainingOtherSection_should_inform_that_if_one_section_contains_other_section_or_not
            (SectionPair givenSectionPair, boolean expectedOneSectionContainsOtherSection) {
        //When
        boolean oneSectionContainsOtherSection = givenSectionPair.isOneSectionFullyContainingOtherSection();

        //Then
        assertThat(oneSectionContainsOtherSection).isEqualTo(expectedOneSectionContainsOtherSection);
    }


    private static Stream<Arguments> inputSectionPairsBis() {
        return Stream.of(
                Arguments.of(SectionPair.of("2-4,6-8"),false),
                Arguments.of(SectionPair.of("2-3,4-5"),false),
                Arguments.of(SectionPair.of("5-7,7-9"),true),
                Arguments.of(SectionPair.of("2-8,3-7"),true),
                Arguments.of(SectionPair.of("6-6,4-6"),true),
                Arguments.of(SectionPair.of("2-6,4-8"),true)
        );
    }
    @ParameterizedTest
    @MethodSource("inputSectionPairsBis")
    void isPairOverlap_should_inform_that_if_one_section_overlap_other_section
            (SectionPair givenSectionPair, boolean expectedPairOverlap) {
        //When
        boolean pairOverlap = givenSectionPair.isPairOverlap();

        //Then
        assertThat(pairOverlap).isEqualTo(expectedPairOverlap);
    }

}