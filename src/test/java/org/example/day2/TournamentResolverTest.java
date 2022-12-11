package org.example.day2;

import org.example.LineExtractor;
import org.example.exception.InvalidDataFromFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TournamentResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day2/inputData.txt");
    }

    @Test
    void resolve_part1_of_day2_problem() throws InvalidDataFromFile {
        Tournament tournament = TournamentResolver.getTournamentFromLines(lines);
        int tournamentScore = tournament.computeTournamentScore();

        assertThat(tournamentScore).isEqualTo(13484);
    }

    @Test
    void resolve_part2_of_day2_problem() throws InvalidDataFromFile {
        Tournament tournament = TournamentResolver.getTournamentType2FromLines(lines);
        int tournamentScore = tournament.computeTournamentScore();

        assertThat(tournamentScore).isEqualTo(13433);
    }

}