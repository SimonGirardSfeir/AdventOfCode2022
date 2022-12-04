package org.example.day4;

import java.util.Arrays;

public record SectionPair(Section firstSection, Section lastSection) {
    public static SectionPair of(String line) {
        Section[] splitedSection = Arrays.stream(line.split(",")).map(Section::of).toArray(Section[]::new);
        return new SectionPair(splitedSection[0],splitedSection[1]);
    }

    public boolean isOneSectionFullyContainingOtherSection() {
        return (firstSection.start() <= lastSection.start() && lastSection.end() <= firstSection().end()) ||
                (lastSection.start() <= firstSection.start() && firstSection.end() <= lastSection().end());
    }
    public boolean isPairOverlap() {
        return !((firstSection.end() < lastSection.start()) || (lastSection.end() < firstSection.start()));
    }
}
