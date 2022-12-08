package org.example.day8;

import java.util.ArrayList;
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
        int scenicScoreLeft = 0;
        int treeHeight = trees[x][y].height();
        for(int i = x-1; i >= 0; i--) {
            scenicScoreLeft++;
            if(trees[i][y].height() >= treeHeight)
                break;
        }
        int scenicScoreRight = 0;
        for(int i = x+1; i < trees.length; i++) {
            scenicScoreRight++;
            if(trees[i][y].height() >= treeHeight)
                break;
        }
        int scenicScoreBottom = 0;
        for(int j = y-1; j >= 0; j--) {
            scenicScoreBottom++;
            if(trees[x][j].height() >= treeHeight)
                break;
        }
        int scenicScoreTop = 0;
        for(int j = y+1; j < trees.length; j++) {
            scenicScoreTop++;
            if(trees[x][j].height() >= treeHeight)
                break;
        }
        return scenicScoreLeft * scenicScoreBottom * scenicScoreTop * scenicScoreRight;
    }

    private boolean isCurrentTreeVisible(int x, int y) {
        int treeHeight = trees[x][y].height();
        List<Tree> treesOnLeft = new ArrayList<>();
        for(int i = 0; i < x; i++) {
            treesOnLeft.add(trees[i][y]);
        }
        int maxHeightOnLeft = maxHeightInRange(treesOnLeft);
        List<Tree> treesOnRight = new ArrayList<>();
        for(int i = x+1; i < trees.length; i++) {
            treesOnRight.add(trees[i][y]);
        }
        int maxHeightOnRight = maxHeightInRange(treesOnRight);
        List<Tree> treesOnBottom = new ArrayList<>(Arrays.asList(trees[x]).subList(0, y));
        int maxHeightOnBottom = maxHeightInRange(treesOnBottom);
        List<Tree> treesOnTop = new ArrayList<>(Arrays.asList(trees[x]).subList(y + 1, trees.length));
        int maxHeightOnTop = maxHeightInRange(treesOnTop);
        return  (treeHeight > maxHeightOnTop) || (treeHeight > maxHeightOnBottom) ||
                (treeHeight > maxHeightOnLeft) || (treeHeight > maxHeightOnRight);

    }
    private int maxHeightInRange(List<Tree> treeRange) {
        int maxHeight = 0;
        for(Tree tree : treeRange) {
            if(tree.height() >= maxHeight)
                maxHeight = tree.height();
        }
        return maxHeight;
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
