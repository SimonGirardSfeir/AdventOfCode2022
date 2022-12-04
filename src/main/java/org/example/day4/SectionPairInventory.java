package org.example.day4;

import java.util.List;

public record SectionPairInventory(List<SectionPair> sectionPairs) {
    public long countSectionPairsWithOneRangeFullyContainingTheOther() {
        return sectionPairs.stream()
                .filter(SectionPair::isOneSectionFullyContainingOtherSection)
                .count();
    }

    public long countSectionPairsWithOverlap() {
        return sectionPairs.stream()
                .filter(SectionPair::isPairOverlap)
                .count();
    }
}
