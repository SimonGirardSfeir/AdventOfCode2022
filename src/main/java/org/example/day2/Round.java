package org.example.day2;

public record Round(Shape shapePlayer, Shape shapeOpponent) {
    public int computeScore() {
        int shapeSelectedScore = shapePlayer.getValue();
        int outCome = shapePlayer.getOutCome(shapeOpponent);
        return shapeSelectedScore + outCome;
    }
}
