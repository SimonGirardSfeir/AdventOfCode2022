package org.example.day4;

import java.util.ArrayList;
import java.util.List;

public class SectionPairResolver {

    public static SectionPairInventory getSectionPairInventoryFromLines(List<String> lines) {
        List<SectionPair> sectionPairs = new ArrayList<>();
        for(String line : lines) {
            SectionPair sectionPair = SectionPair.of(line);
            sectionPairs.add(sectionPair);
        }
        return new SectionPairInventory(sectionPairs);
    }
}
