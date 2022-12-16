package org.example.day13;

import org.example.LineExtractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PacketsPairResolverTest {

    private List<String> lines;

    @BeforeEach
    void setUp() throws IOException {
        lines = LineExtractor.getLines("src/test/resources/day13/inputData.txt");
    }

    @Test
    void resolve_part1_of_day13_problem() {
        //Given
        PacketsPairInventory givenPacketsPairInventory = PacketsPairResolver.getPacketsPairInventoryFromLines(lines);

        //When
        int sumOfPairsInRightOrderIndexes = givenPacketsPairInventory.computeSumOfPairsInRightOrderIndexes();

        //Then
        assertThat(sumOfPairsInRightOrderIndexes).isEqualTo(5557);
    }

    @Test
    void resolve_part2_of_day13_problem() {
        //Given
        PacketsPairInventory givenPacketsPairInventory = PacketsPairResolver.getPacketsPairInventoryFromLines(lines);

        //When
        int distressSignal = givenPacketsPairInventory.computeDistressSignal();

        //Then
        assertThat(distressSignal).isEqualTo(22425);
    }
}