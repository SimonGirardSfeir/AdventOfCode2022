package org.example.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SectionPairResolver {
    private SectionPairResolver() {
    }

    public static SectionPairInventory getSectionPairInventoryFromLines(List<String> lines) {
        List<SectionPair> sectionPairs = new ArrayList<>();
        for(String line : lines) {
            Section[] splitedSection = Arrays.stream(line.split(","))
                    .map(line1 -> Section.of(getSectionLimits(line1)))
                    .toArray(Section[]::new);
            SectionPair sectionPair = new SectionPair(splitedSection[0],splitedSection[1]);
            sectionPairs.add(sectionPair);
        }
        return new SectionPairInventory(sectionPairs);
    }

    private static Integer[] getSectionLimits(String line) {
        return Arrays.stream(line.split("-")).map(Integer::valueOf).toArray(Integer[]::new);
    }
}
