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
    public int accept(FileVisitor fileVisitor) {
        return fileVisitor.visitDirectoryInformation(this);
    }

    @Override
    public int accept(FileVisitor fileVisitor, int spaceNeededToFreeUp) {
        return fileVisitor.visitDirectoryInformation(this, spaceNeededToFreeUp);
    }

    @Override
    public int accept(FileVisitor fileVisitor, int maxSize, AtomicInteger currentSum) {
        int directorySize = fileVisitor.visitDirectoryInformation(this, maxSize, currentSum);
        if(directorySize <= maxSize)
            currentSum.addAndGet(directorySize);

        return directorySize;
    }
}
