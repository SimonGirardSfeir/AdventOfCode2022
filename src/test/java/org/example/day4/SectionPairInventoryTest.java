package org.example.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SectionPairInventoryTest {

    @Test
    void countSectionPairsWithOneRangeFullyContainingTheOther_should_give_the_number_of_section_pairs_with_one_range_fully_containing_the_other() {
        //Given
        SectionPair sectionPair1 = SectionPair.of("2-4,6-8");
        SectionPair sectionPair2 = SectionPair.of("2-3,4-5");
        SectionPair sectionPair3 = SectionPair.of("5-7,7-9");
        SectionPair sectionPair4 = SectionPair.of("2-8,3-7");
        SectionPair sectionPair5 = SectionPair.of("6-6,4-6");
        SectionPair sectionPair6 = SectionPair.of("2-6,4-8");
        List<SectionPair> sectionPairs = List.of(sectionPair1, sectionPair2, sectionPair3, sectionPair4, sectionPair5, sectionPair6);
        SectionPairInventory sectionPairInventory = new SectionPairInventory(sectionPairs);

        //When
        long numberOfSectionPairsWithOneRangeFullyContainingTheOther = sectionPairInventory.countSectionPairsWithOneRangeFullyContainingTheOther();

        //Then
        long expectedNumberOfSectionPairsWithOneRangeFullyContainingTheOther = 2L;
        assertThat(numberOfSectionPairsWithOneRangeFullyContainingTheOther).isEqualTo(expectedNumberOfSectionPairsWithOneRangeFullyContainingTheOther);
    }

    @Test
    void countSectionPairswithOverlap_should_give_the_number_of_section_pairs_with_overlap() {
        //Given
        SectionPair sectionPair1 = SectionPair.of("2-4,6-8");
        SectionPair sectionPair2 = SectionPair.of("2-3,4-5");
        SectionPair sectionPair3 = SectionPair.of("5-7,7-9");
        SectionPair sectionPair4 = SectionPair.of("2-8,3-7");
        SectionPair sectionPair5 = SectionPair.of("6-6,4-6");
        SectionPair sectionPair6 = SectionPair.of("2-6,4-8");
        List<SectionPair> sectionPairs = List.of(sectionPair1, sectionPair2, sectionPair3, sectionPair4, sectionPair5, sectionPair6);
        SectionPairInventory sectionPairInventory = new SectionPairInventory(sectionPairs);

        //When
        long numberOfSectionPairsWithOverlap = sectionPairInventory.countSectionPairsWithOverlap();

        //Then
        long expectedNumberOfSectionPairsWithOverlap = 4L;
        assertThat(numberOfSectionPairsWithOverlap).isEqualTo(expectedNumberOfSectionPairsWithOverlap);
    }

}