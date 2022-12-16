package org.example.day13;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PacketTest {

    private static Stream<Arguments> packetsToCompare() {
        return Stream.of(
                Arguments.of(new Packet("[1,1,3,1,1]"), new Packet("[1,1,5,1,1]"), -1),
                Arguments.of(new Packet("[[1],[2,3,4]]"), new Packet("[[1],4]"), -1),
                Arguments.of(new Packet("[9]"), new Packet("[[8,7,6]]"), 1),
                Arguments.of(new Packet("[[4,4],4,4]"), new Packet("[[4,4],4,4,4]"), -1),
                Arguments.of(new Packet("[7,7,7,7]"), new Packet("[7,7,7]"), 1),
                Arguments.of(new Packet("[]"), new Packet("[3]"), -1),
                Arguments.of(new Packet("[[[]]]"), new Packet("[[]]"), 1),
                Arguments.of(new Packet("[1,[2,[3,[4,[5,6,7]]]],8,9]"), new Packet("[1,[2,[3,[4,[5,6,0]]]],8,9]"), 1)
        );
    }
    @ParameterizedTest
    @MethodSource("packetsToCompare")
    void compareTo_should_give_expected_outcome(Packet givenPacket, Packet packetToCompare, int expectedOutcome) {
        //When
        int outcome = givenPacket.compareTo(packetToCompare);

        //Then
        assertThat(outcome).isEqualTo(expectedOutcome);
    }

}