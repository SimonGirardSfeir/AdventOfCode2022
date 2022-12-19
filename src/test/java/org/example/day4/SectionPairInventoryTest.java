package org.example.day4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SectionPairInventoryTest {

    @Test
    void countSectionPairsWithOneRangeFullyContainingTheOther_should_give_the_number_of_section_pairs_with_one_range_fully_containing_the_other() {
        //Given
        SectionPair sectionPair1 = new SectionPair(new Section(2,4), new Section(6,8));
        SectionPair sectionPair2 = new SectionPair(new Section(2,4), new Section(6,8));
        SectionPair sectionPair3 = new SectionPair(new Section(5,7), new Section(7,9));
        SectionPair sectionPair4 = new SectionPair(new Section(2,8), new Section(3,7));
        SectionPair sectionPair5 = new SectionPair(new Section(6,6), new Section(4,6));
        SectionPair sectionPair6 = new SectionPair(new Section(2,6), new Section(4,8));
        List<SectionPair> sectionPairs = List.of(sectionPair1, sectionPair2, sectionPair3, sectionPair4, sectionPair5, sectionPair6);
        SectionPairInventory sectionPairInventory = new SectionPairInventory(sectionPairs);

        //When
        long numberOfSectionPairsWithOneRangeFullyContainingTheOther = sectionPairInventory.countSectionPairsWithOneRangeFullyContainingTheOther();

        //Then
        long expectedNumberOfSectionPairsWithOneRangeFullyContainingTheOther = 2L;
        assertThat(numberOfSectionPairsWithOneRangeFullyContainingTheOther).isEqualTo(expectedNumberOfSectionPairsWithOneRangeFullyContainingTheOther);
    }

    @Test
    void countSectionPairsWithOverlap_should_give_the_number_of_section_pairs_with_overlap() {
        //Given
        SectionPair sectionPair1 = new SectionPair(new Section(2,4), new Section(6,8));
        SectionPair sectionPair2 = new SectionPair(new Section(2,4), new Section(6,8));
        SectionPair sectionPair3 = new SectionPair(new Section(5,7), new Section(7,9));
        SectionPair sectionPair4 = new SectionPair(new Section(2,8), new Section(3,7));
        SectionPair sectionPair5 = new SectionPair(new Section(6,6), new Section(4,6));
        SectionPair sectionPair6 = new SectionPair(new Section(2,6), new Section(4,8));
        List<SectionPair> sectionPairs = List.of(sectionPair1, sectionPair2, sectionPair3, sectionPair4, sectionPair5, sectionPair6);
        SectionPairInventory sectionPairInventory = new SectionPairInventory(sectionPairs);

        //When
        long numberOfSectionPairsWithOverlap = sectionPairInventory.countSectionPairsWithOverlap();

        //Then
        long expectedNumberOfSectionPairsWithOverlap = 4L;
        assertThat(numberOfSectionPairsWithOverlap).isEqualTo(expectedNumberOfSectionPairsWithOverlap);
    }

}