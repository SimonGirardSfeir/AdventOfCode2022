package org.example.day13;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PacketsPairTest {

    private static Stream<Arguments> packetsPair() {
        return Stream.of(
                Arguments.of(new PacketsPair(new Packet("[1,1,3,1,1]"), new Packet("[1,1,5,1,1]")), true),
                Arguments.of(new PacketsPair(new Packet("[[1],[2,3,4]]"), new Packet("[[1],4]")), true),
                Arguments.of(new PacketsPair(new Packet("[9]"), new Packet("[[8,7,6]]")), false),
                Arguments.of(new PacketsPair(new Packet("[[4,4],4,4]"), new Packet("[[4,4],4,4,4]")), true),
                Arguments.of(new PacketsPair(new Packet("[7,7,7,7]"), new Packet("[7,7,7]")), false),
                Arguments.of(new PacketsPair(new Packet("[]"), new Packet("[3]")), true),
                Arguments.of(new PacketsPair(new Packet("[[[]]]"), new Packet("[[]]")), false),
                Arguments.of(new PacketsPair(new Packet("[1,[2,[3,[4,[5,6,7]]]],8,9]"), new Packet("[1,[2,[3,[4,[5,6,0]]]],8,9]")), false)
        );
    }
    @ParameterizedTest
    @MethodSource("packetsPair")
    void isInRightOrder_should_give_expected_outcome(PacketsPair givenPacketsPair, boolean expectedOutcome) {
        //When
        boolean isInRightOrder = givenPacketsPair.isInRightOrder();

        //Then
        assertThat(isInRightOrder).isEqualTo(expectedOutcome);
    }
}