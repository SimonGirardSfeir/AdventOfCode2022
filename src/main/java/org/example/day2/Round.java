package org.example.day2;

public record Round(Shape shapePlayer, Shape shapeOpponent) {
    public int computePlayerScore() {
        return shapePlayer.value + shapePlayer.getOutcome(shapeOpponent).value;
    }
}
