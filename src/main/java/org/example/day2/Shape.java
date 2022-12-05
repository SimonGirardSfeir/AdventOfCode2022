package org.example.day2;

import static org.example.day2.Outcome.DRAW;
import static org.example.day2.Outcome.LOSE;
import static org.example.day2.Outcome.WIN;

public enum Shape {
    ROCK(1) {
        @Override
        public Outcome getOutcome(Shape opponentShape) {
            return switch(opponentShape) {
                case PAPER -> LOSE;
                case SCISSORS -> WIN;
                case ROCK -> DRAW;
            };
        }
        @Override
        public Shape winAgainst() {
            return SCISSORS;
        }
        @Override
        public Shape loseAgainst() {
            return PAPER;
        }
    }, PAPER(2) {
        @Override
        public Outcome getOutcome(Shape opponentShape) {
            return switch(opponentShape) {
                case PAPER -> DRAW;
                case SCISSORS -> LOSE;
                case ROCK -> WIN;
            };
        }
        @Override
        public Shape winAgainst() {
            return ROCK;
        }
        @Override
        public Shape loseAgainst() {
            return SCISSORS;
        }
    }, SCISSORS(3) {
        @Override
        public Outcome getOutcome(Shape opponentShape) {
            return switch(opponentShape) {
                case PAPER -> WIN;
                case SCISSORS -> DRAW;
                case ROCK -> LOSE;
            };
        }
        @Override
        public Shape winAgainst() {
            return PAPER;
        }
        @Override
        public Shape loseAgainst() {
            return ROCK;
        }
    };

    public final int value;

    Shape(int value) {
        this.value = value;
    }

    public abstract Outcome getOutcome(Shape opponentShape);
    public abstract Shape winAgainst();
    public abstract Shape loseAgainst();
}
