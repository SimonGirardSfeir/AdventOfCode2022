package org.example.day2;

import org.example.day2.exception.InvalidDataFromFile;

import java.util.ArrayList;
import java.util.List;

public class Resolver {

    private Resolver () {
    }
    public static Tournament getTournamentFromLines(List<String> lines) {
        List<Round> rounds = new ArrayList<>();
        Tournament tournament = new Tournament(rounds);

        for(String line : lines) {
            String[] splittedLine = lineSpliter(line);
            Shape playerShape;
            Shape opponentShape;
            switch (splittedLine[0]) {
                case "A" -> opponentShape = Shape.ROCK;
                case "B" -> opponentShape = Shape.PAPER;
                case "C" -> opponentShape = Shape.SCISSORS;
                default -> throw new InvalidDataFromFile();
            }
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
            Shape opponentShape;
            switch (splittedLine[0]) {
                case "A" -> opponentShape = Shape.ROCK;
                case "B" -> opponentShape = Shape.PAPER;
                case "C" -> opponentShape = Shape.SCISSORS;
                default -> throw new InvalidDataFromFile();
            }
            switch (splittedLine[1]) {
                case "X" -> playerShape = opponentShape.getShapeWeWin();
                case "Y" -> playerShape = opponentShape;
                case "Z" -> playerShape = opponentShape.getShapeWeLose();
                default -> throw new InvalidDataFromFile();
            }
            Round tempRound = new Round(playerShape, opponentShape);
            rounds.add(tempRound);
        }

        return tournament;

    }

    private static String[] lineSpliter(String line) {
        return line.split(" ");
    }
}
