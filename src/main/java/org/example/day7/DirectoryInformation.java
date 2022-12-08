package org.example.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record DirectoryInformation(String name, List<Node> subElements) implements Node {

    public static DirectoryInformation of(String name, List<String> lines) {
        List<Node> subElements = new ArrayList<>();
        for (String line : lines) {
            if (!line.contains("dir")) {
                subElements.add(FileInformation.of(line));
            } else {
                subElements.add(DirectoryInformation.of(line.split(" ")[1], new ArrayList<>()));
            }
        }
        return new DirectoryInformation(name, subElements);
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.directoryInformationVisitor(this);
    }
    @Override
    public int acceptSizeLimitedDirectories(Visitor visitor, int maxSize, AtomicInteger counter) {
        int directorySize = visitor.directoryInformationVisitor(this);
        if(directorySize <= maxSize)
            counter.addAndGet(directorySize);

        return directorySize;
    }
    @Override
    public int acceptSmallestDirectory(Visitor visitor, int spaceNeededToFreeUp, AtomicInteger counter) {
        int directorySize = visitor.directoryInformationVisitor(this);
        if(counter.get() > directorySize && directorySize > spaceNeededToFreeUp)
            counter.set(directorySize);
        return directorySize;
    }
}
