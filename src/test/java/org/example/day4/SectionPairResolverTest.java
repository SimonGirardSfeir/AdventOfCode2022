package org.example.day4;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SectionPairResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day4/inputData.txt");
    }

    @Test
    void resolve_part1_of_day4_problem() {
        //Given
        SectionPairInventory sectionPairInventory = SectionPairResolver.getSectionPairInventoryFromLines(lines);

        //When
        long numberOfSectionPairsWithOneRangeFullyContainingTheOther = sectionPairInventory.countSectionPairsWithOneRangeFullyContainingTheOther();

        //Then
        assertThat(numberOfSectionPairsWithOneRangeFullyContainingTheOther).isEqualTo(450);
    }

    @Test
    void resolve_part2_of_day4_problem() {
        //Given
        SectionPairInventory sectionPairInventory = SectionPairResolver.getSectionPairInventoryFromLines(lines);

        //When
        long numberOfSectionPairsWithOneRangeFullyContainingTheOther = sectionPairInventory.countSectionPairsWithOverlap();

        //Then
        assertThat(numberOfSectionPairsWithOneRangeFullyContainingTheOther).isEqualTo(837);
    }
}