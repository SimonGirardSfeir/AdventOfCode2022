package org.example.day7;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface Node {
    String name();
    List<Node> subElements();
    int accept(FileVisitor fileVisitor);
    int accept(FileVisitor fileVisitor, int spaceNeededToFreeUp);
    int accept(FileVisitor fileVisitor, int maxSize, AtomicInteger currentSum);
}
