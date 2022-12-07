package org.example.day7;

import java.util.concurrent.atomic.AtomicInteger;

public class FileVisitor {

    int currentSpaceToFree = Integer.MAX_VALUE;
    public int countNodeTotalSizeOfNodesWithSizeUpToMaxSize(Node node, int maxSize) {
        //We use a mutable integer to take advantage of this pattern
        AtomicInteger currentSum = new AtomicInteger(0);
        node.accept(this, maxSize, currentSum);
        return currentSum.get();
    }
    public int visitFileInformation(FileInformation fileInformation) {
        return fileInformation.fileSize();
    }

    public int visitDirectoryInformation(DirectoryInformation directoryInformation) {
        int nodeSize = 0;
        for(Node node : directoryInformation.subElements()) {
            nodeSize += node.accept(this);
        }
        return nodeSize;
    }
    public int visitDirectoryInformation(DirectoryInformation directoryInformation, int spaceNeedToFreeUp) {
        int nodeSize = 0;
        for(Node node : directoryInformation.subElements()) {
            nodeSize += node.accept(this, spaceNeedToFreeUp);
        }
        if(nodeSize < currentSpaceToFree && nodeSize >= spaceNeedToFreeUp)
            currentSpaceToFree = nodeSize;
        return nodeSize;
    }
    public int visitDirectoryInformation(DirectoryInformation directoryInformation, int maxSize, AtomicInteger currentSum) {
        int nodeSize = 0;
        for(Node node : directoryInformation.subElements()) {
            nodeSize += node.accept(this, maxSize, currentSum);
        }

        return nodeSize;
    }

    public int computeTotalSizeOfSmallestDirectoryBigEnoughToDeleteForFreeUpEnoughSpaceForSystemUpdate
            (Node node, int totalDiskSpace, int unusedSpaceNeeded) {
        int totalSpaceUsed = node.accept(this);

        int spaceNeedToFreeUp = unusedSpaceNeeded - (totalDiskSpace - totalSpaceUsed);

        node.accept(this, spaceNeedToFreeUp);

        return currentSpaceToFree;
    }
}
