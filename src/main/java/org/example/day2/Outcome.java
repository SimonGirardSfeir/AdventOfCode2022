package org.example.day2;

public enum Outcome {
    WIN(6), LOSE(0), DRAW(3);

    public final int value;

    Outcome(int value) {
        this.value = value;
    }
}
