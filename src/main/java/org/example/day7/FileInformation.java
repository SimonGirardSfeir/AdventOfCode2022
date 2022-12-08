package org.example.day7;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record FileInformation(String name, int fileSize) implements Node {

    public static FileInformation of(String line) {
        String[] splitedLine = line.split(" ");
        return new FileInformation(splitedLine[1], Integer.parseInt(splitedLine[0]));
    }

    @Override
    public List<Node> subElements() {
        return Collections.emptyList();
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.fileInformationVisitor(this);
    }
    @Override
    public int acceptSizeLimitedDirectories(Visitor visitor, int maxSize, AtomicInteger counter) {
        return accept(visitor);
    }
    @Override
    public int acceptSmallestDirectory(Visitor visitor, int spaceNeededToFreeUp, AtomicInteger counter) {
        return accept(visitor);
    }
}
