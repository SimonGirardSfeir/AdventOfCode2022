package org.example.day4;

public record SectionPair(Section firstSection, Section lastSection) {
    public boolean isOneSectionFullyContainingOtherSection() {
        return (firstSection.start() <= lastSection.start() && lastSection.end() <= firstSection().end()) ||
                (lastSection.start() <= firstSection.start() && firstSection.end() <= lastSection().end());
    }
    public boolean isPairOverlap() {
        return !((firstSection.end() < lastSection.start()) || (lastSection.end() < firstSection.start()));
    }
}
