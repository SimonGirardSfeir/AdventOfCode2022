package org.example.day8;

import java.util.List;

public final class ForestResolver {
    private ForestResolver() {
    }

    public static Forest getForestFromLines(List<String> lines) {
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
}
