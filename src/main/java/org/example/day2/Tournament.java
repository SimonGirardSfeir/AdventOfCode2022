package org.example.day2;

import java.util.List;

public record Tournament(List<Round> rounds) {
    public int computeTournamentScore() {
        return rounds.stream().map(Round::computePlayerScore).reduce(0, Integer::sum);
    }
}
