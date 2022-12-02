package org.example.day2;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day2/inputData.txt");
    }

    @Test
    void resolve_part1_of_day2_problem() {
        Tournament tournament = org.example.day2.Resolver.getTournamentFromLines(lines);
        int tournamentScore = tournament.computeTournamentScore();

        assertThat(tournamentScore).isEqualTo(13484);
    }

    @Test
    void resolve_part2_of_day1_problem() {
        Tournament tournament = org.example.day2.Resolver.getTournamentType2FromLines(lines);
        int tournamentScore = tournament.computeTournamentScore();

        assertThat(tournamentScore).isEqualTo(13433);
    }

}