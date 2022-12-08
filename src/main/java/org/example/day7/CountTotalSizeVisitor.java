package org.example.day7;

public class CountTotalSizeVisitor implements Visitor {
    @Override
    public int perform(Node node) {
        return node.accept(this);
    }
    @Override
    public int directoryInformationVisitor(DirectoryInformation directoryInformation) {
        int nodeSize = 0;
        for(Node node : directoryInformation.subElements()) {
            nodeSize += node.accept(this);
        }
        return nodeSize;
    }
}
