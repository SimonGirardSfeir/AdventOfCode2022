package org.example.day7;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public interface Node {
    String name();
    List<Node> subElements();
    int accept(Visitor visitor);
    int acceptSizeLimitedDirectories(Visitor visitor, int maxSize, AtomicInteger counter);
    int acceptSmallestDirectory(Visitor visitor, int spaceNeededToFreeUp, AtomicInteger counter);
}
