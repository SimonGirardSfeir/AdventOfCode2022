package org.example.day8;

import java.util.Arrays;
import java.util.List;

public record Forest(Tree[][] trees) {
    public static Forest of(List<String> lines) {
        int westEastLength = lines.get(0).length();
        int northSouthLength = lines.size();
        Tree[][] trees = new Tree[westEastLength][northSouthLength];

        for(int j = 0; j< lines.size(); j++) {
            String line = lines.get(j);
            Tree[] treeLine = new Tree[westEastLength];
            for(int i = 0; i < line.length(); i++) {
                int treeHeight = Integer.parseInt(String.valueOf(line.charAt(i)));
                treeLine[i] = new Tree(treeHeight);
            }
            trees[j] = treeLine;
        }
        return new Forest(trees);
    }

    public int countVisibleTrees() {
        int numberOfVisibleTrees = trees().length*4 - 4;

        for(int x = 1; x < trees.length -1; x++) {
            for(int y = 1; y < trees.length -1; y++) {
                if(isCurrentTreeVisible(x,y)) {
                    numberOfVisibleTrees++;
                }
            }
        }
        return numberOfVisibleTrees;
    }
    public int getHighestScenicScoreInForest() {
        int highestScenicScore = 0;
        for(int x = 1; x < trees.length -1; x++) {
            for(int y = 1; y < trees.length -1; y++) {
                if(currentTreeScenicScore(x,y) > highestScenicScore) {
                    highestScenicScore = currentTreeScenicScore(x,y);
                }
            }
        }
        return highestScenicScore;
    }

    private int currentTreeScenicScore(int x, int y) {
        int treesSeenOnLeft = 0;
        int treeHeight = trees[x][y].height();
        for(int i = x-1; i >= 0; i--) {
            treesSeenOnLeft++;
            if(trees[i][y].height() >= treeHeight)
                break;
        }
        int treesSeenOnRight = 0;
        for(int i = x+1; i < trees.length; i++) {
            treesSeenOnRight++;
            if(trees[i][y].height() >= treeHeight)
                break;
        }
        int treesSeenOnBottom = 0;
        for(int j = y-1; j >= 0; j--) {
            treesSeenOnBottom++;
            if(trees[x][j].height() >= treeHeight)
                break;
        }
        int treesSeenOnTop = 0;
        for(int j = y+1; j < trees.length; j++) {
            treesSeenOnTop++;
            if(trees[x][j].height() >= treeHeight)
                break;
        }
        return treesSeenOnLeft * treesSeenOnBottom * treesSeenOnTop * treesSeenOnRight;
    }
    private boolean isCurrentTreeVisible(int x, int y) {
        int treeHeight = trees[x][y].height();
        int maxHeightOnLeft = 0;
        for(int i = 0; i < x; i++) {
            if(trees[i][y].height() > maxHeightOnLeft)
                maxHeightOnLeft = trees[i][y].height();
        }
        int maxHeightOnRight = 0;
        for(int i = x+1; i < trees.length; i++) {
            if(trees[i][y].height() > maxHeightOnRight)
                maxHeightOnRight = trees[i][y].height();
        }
        int maxHeightOnBottom = 0;
        for(int j = 0; j < y; j++) {
            if(trees[x][j].height() > maxHeightOnBottom)
                maxHeightOnBottom = trees[x][j].height();
        }
        int maxHeightOnTop = 0;
        for(int j = y+1; j < trees.length; j++) {
            if(trees[x][j].height() > maxHeightOnTop)
                maxHeightOnTop = trees[x][j].height();
        }

        return  (treeHeight > maxHeightOnTop) || (treeHeight > maxHeightOnBottom) ||
                (treeHeight > maxHeightOnLeft) || (treeHeight > maxHeightOnRight);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forest forest = (Forest) o;
        return Arrays.deepEquals(trees, forest.trees);
    }
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(trees);
    }

    @Override
    public String toString() {
        return "Forest{" +
                "trees=" + Arrays.toString(trees) +
                '}';
    }
}
