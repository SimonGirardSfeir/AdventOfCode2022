package org.example.day4;

import java.util.Arrays;
import java.util.List;

public final class SectionPairResolver {
    private SectionPairResolver() {
    }

    public static SectionPairInventory getSectionPairInventoryFromLines(List<String> lines) {
        List<SectionPair> sectionPairs = lines.stream()
                .map(SectionPairResolver::createSectionPairFromString)
                .toList();
        return new SectionPairInventory(sectionPairs);
    }
    private static SectionPair createSectionPairFromString(String line) {
        Section[] splittedSection = Arrays.stream(line.split(","))
                .map(line1 -> Section.of(getSectionLimits(line1)))
                .toArray(Section[]::new);
        return new SectionPair(splittedSection[0], splittedSection[1]);
    }
    private static Integer[] getSectionLimits(String line) {
        return Arrays.stream(line.split("-")).map(Integer::valueOf).toArray(Integer[]::new);
    }
}
