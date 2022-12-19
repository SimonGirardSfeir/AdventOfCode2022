package org.example.day4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SectionPairTest {

    private static Stream<Arguments> inputSectionPairs() {
        return Stream.of(
                Arguments.of(new SectionPair(new Section(2,8), new Section(3,7)),true),
                Arguments.of(new SectionPair(new Section(6,6), new Section(4,6)),true),
                Arguments.of(new SectionPair(new Section(2,4), new Section(6,8)),false)
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
                Arguments.of(new SectionPair(new Section(2,4), new Section(6,8)),false),
                Arguments.of(new SectionPair(new Section(2,4), new Section(6,8)),false),
                Arguments.of(new SectionPair(new Section(5,7), new Section(7,9)),true),
                Arguments.of(new SectionPair(new Section(2,8), new Section(3,7)),true),
                Arguments.of(new SectionPair(new Section(6,6), new Section(4,6)),true),
                Arguments.of(new SectionPair(new Section(2,6), new Section(4,8)),true)
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