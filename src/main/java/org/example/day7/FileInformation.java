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
    public int accept(FileVisitor fileVisitor) {
        return fileVisitor.visitFileInformation(this);
    }
    @Override
    public int accept(FileVisitor fileVisitor, int spaceNeededToFreeUp) {
        return accept(fileVisitor);
    }
    @Override
    public int accept(FileVisitor fileVisitor, int maxSize, AtomicInteger currentSum) {
        return accept(fileVisitor);
    }

}
