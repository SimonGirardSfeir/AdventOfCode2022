package org.example.day7;

import java.util.concurrent.atomic.AtomicInteger;

public class CountTotalSizeLimitedDirectoriesVisitor implements Visitor {

    private final int directoryMaxSize;
    private final AtomicInteger counter = new AtomicInteger(0);

    public CountTotalSizeLimitedDirectoriesVisitor(int directoryMaxSize) {
        this.directoryMaxSize = directoryMaxSize;
    }

    @Override
    public int perform(Node node) {
        node.acceptSizeLimitedDirectories(this, directoryMaxSize, counter);
        return counter.get();
    }
    @Override
    public int directoryInformationVisitor(DirectoryInformation directoryInformation) {
        int nodeSize = 0;
        for(Node node : directoryInformation.subElements()) {
            nodeSize += node.acceptSizeLimitedDirectories(this, directoryMaxSize, counter);
        }

        return nodeSize;
    }
}
