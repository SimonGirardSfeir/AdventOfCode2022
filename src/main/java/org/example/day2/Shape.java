package org.example.day2;

public enum Shape {
    ROCK(1) {
        @Override
        public int getOutCome(Shape opponentShape) {
            return switch(opponentShape) {
                case PAPER -> 0;
                case SCISSORS -> 6;
                case ROCK -> 3;
            };
        }

        @Override
        public Shape getShapeWeWin() {
            return SCISSORS;
        }

        @Override
        public Shape getShapeWeLose() {
            return PAPER;
        }
    }, PAPER(2) {
        @Override
        public int getOutCome(Shape opponentShape) {
            return switch(opponentShape) {
                case PAPER -> 3;
                case SCISSORS -> 0;
                case ROCK -> 6;
            };
        }

        @Override
        public Shape getShapeWeWin() {
            return ROCK;
        }

        @Override
        public Shape getShapeWeLose() {
            return SCISSORS;
        }
    }, SCISSORS(3) {
        @Override
        public int getOutCome(Shape opponentShape) {
            return switch(opponentShape) {
                case PAPER -> 6;
                case SCISSORS -> 3;
                case ROCK -> 0;
            };
        }

        @Override
        public Shape getShapeWeWin() {
            return PAPER;
        }

        @Override
        public Shape getShapeWeLose() {
            return ROCK;
        }
    };

    public final int value;

    Shape(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract int getOutCome(Shape opponentShape);

    public abstract Shape getShapeWeWin();
    public abstract Shape getShapeWeLose();
}
