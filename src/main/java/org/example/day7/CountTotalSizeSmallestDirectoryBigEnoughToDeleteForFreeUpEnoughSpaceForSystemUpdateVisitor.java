package org.example.day7;

import java.util.concurrent.atomic.AtomicInteger;

public class CountTotalSizeSmallestDirectoryBigEnoughToDeleteForFreeUpEnoughSpaceForSystemUpdateVisitor implements Visitor {

    private final int maxDiskSpaceForUpdate;
    private int spaceNeedToFreeUp;
    private final AtomicInteger counter = new AtomicInteger(0);

    public CountTotalSizeSmallestDirectoryBigEnoughToDeleteForFreeUpEnoughSpaceForSystemUpdateVisitor(int maxDiskSpaceForUpdate) {
        this.maxDiskSpaceForUpdate = maxDiskSpaceForUpdate;
    }

    @Override
    public int perform(Node node) {
        int totalSpaceUsed = node.accept(this);
        spaceNeedToFreeUp = totalSpaceUsed - maxDiskSpaceForUpdate;
        counter.set(totalSpaceUsed);
        node.acceptSmallestDirectory(this, spaceNeedToFreeUp, counter);
        return counter.get();
    }
    @Override
    public int directoryInformationVisitor(DirectoryInformation directoryInformation) {
        int nodeSize = 0;
        for(Node node : directoryInformation.subElements()) {
            nodeSize += node.acceptSmallestDirectory(this, spaceNeedToFreeUp, counter);
        }

        return nodeSize;
    }
}
