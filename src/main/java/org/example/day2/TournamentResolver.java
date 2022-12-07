package org.example.day2;

import org.example.exception.InvalidDataFromFile;

import java.util.ArrayList;
import java.util.List;

public class TournamentResolver {
    private TournamentResolver() {
    }

    public static Tournament getTournamentFromLines(List<String> lines) {
        List<Round> rounds = new ArrayList<>();
        Tournament tournament = new Tournament(rounds);

        for(String line : lines) {
            String[] splittedLine = lineSpliter(line);
            Shape playerShape;
            Shape opponentShape;
            opponentShape = getOpponentShape(splittedLine[0]);
            switch (splittedLine[1]) {
                case "X" -> playerShape = Shape.ROCK;
                case "Y" -> playerShape = Shape.PAPER;
                case "Z" -> playerShape = Shape.SCISSORS;
                default -> throw new InvalidDataFromFile();
            }
            Round tempRound = new Round(playerShape, opponentShape);
            rounds.add(tempRound);
        }

        return tournament;

    }
    public static Tournament getTournamentType2FromLines(List<String> lines) {
        List<Round> rounds = new ArrayList<>();
        Tournament tournament = new Tournament(rounds);

        for(String line : lines) {
            String[] splittedLine = lineSpliter(line);
            Shape playerShape;
            Shape opponentShape = getOpponentShape(splittedLine[0]);
            switch (splittedLine[1]) {
                case "X" -> playerShape = opponentShape.winAgainst();
                case "Y" -> playerShape = opponentShape;
                case "Z" -> playerShape = opponentShape.loseAgainst();
                default -> throw new InvalidDataFromFile();
            }
            Round tempRound = new Round(playerShape, opponentShape);
            rounds.add(tempRound);
        }

        return tournament;

    }
    private static Shape getOpponentShape(String leftPartLine) {
        Shape opponentShape;
        switch (leftPartLine) {
            case "A" -> opponentShape = Shape.ROCK;
            case "B" -> opponentShape = Shape.PAPER;
            case "C" -> opponentShape = Shape.SCISSORS;
            default -> throw new InvalidDataFromFile();
        }
        return opponentShape;
    }
    private static String[] lineSpliter(String line) {
        return line.split(" ");
    }
}
