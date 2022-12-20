package org.example.day8;

import java.util.Arrays;

public record Forest(Tree[][] trees) {
    private static final int NUMBER_OF_RECTANGULAR_EDGE = 4;

    public int countVisibleTrees() {
        int numberOfVisibleTrees = NUMBER_OF_RECTANGULAR_EDGE*(trees().length - 1);

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
        int maxHeightOnLeft = checkTreesHeightHorizontally(0, x,y);
        int maxHeightOnRight = checkTreesHeightHorizontally(x+1, trees.length,y);
        int maxHeightOnBottom = checkTreesHeightVertically(0, y, x);
        int maxHeightOnTop = checkTreesHeightVertically(y+1, trees.length, x);

        return  (treeHeight > maxHeightOnTop) || (treeHeight > maxHeightOnBottom) ||
                (treeHeight > maxHeightOnLeft) || (treeHeight > maxHeightOnRight);

    }
    private int checkTreesHeightVertically(int yLowerLimit, int yUpperLimit, int currentX) {
        int numberOfTrees = 0;
        for(int j = yLowerLimit; j < yUpperLimit; j++) {
            if(trees[currentX][j].height() > numberOfTrees)
                numberOfTrees = trees[currentX][j].height();
        }
        return numberOfTrees;
    }
    private int checkTreesHeightHorizontally(int xLowerLimit, int xUpperLimit, int currentY) {
        int numberOfTrees = 0;
        for(int i = xLowerLimit; i < xUpperLimit; i++) {
            if(trees[i][currentY].height() > numberOfTrees)
                numberOfTrees = trees[i][currentY].height();
        }
        return numberOfTrees;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
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
