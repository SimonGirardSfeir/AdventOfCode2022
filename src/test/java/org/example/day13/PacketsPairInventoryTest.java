package org.example.day13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class PacketsPairInventoryTest {

    @Test
    void computeSumOfPairsInRightOrderIndexes_should_give_sum_of_the_indices_of_pairs_in_right_order() {
        //Given
        PacketsPair packetsPair1 = new PacketsPair(new Packet("[1,1,3,1,1]"), new Packet("[1,1,5,1,1]"));
        PacketsPair packetsPair2 = new PacketsPair(new Packet("[[1],[2,3,4]]"), new Packet("[[1],4]"));
        PacketsPair packetsPair3 = new PacketsPair(new Packet("[9]"), new Packet("[[8,7,6]]"));
        PacketsPair packetsPair4 = new PacketsPair(new Packet("[[4,4],4,4]"), new Packet("[[4,4],4,4,4]"));
        PacketsPair packetsPair5 = new PacketsPair(new Packet("[7,7,7,7]"), new Packet("[7,7,7]"));
        PacketsPair packetsPair6 = new PacketsPair(new Packet("[]"), new Packet("[3]"));
        PacketsPair packetsPair7 = new PacketsPair(new Packet("[[[]]]"), new Packet("[[]]"));
        PacketsPair packetsPair8 = new PacketsPair(new Packet("[1,[2,[3,[4,[5,6,7]]]],8,9]"), new Packet("[1,[2,[3,[4,[5,6,0]]]],8,9]"));
        PacketsPairInventory givenPacketsPairInventory = new PacketsPairInventory(List.of(packetsPair1, packetsPair2, packetsPair3, packetsPair4, packetsPair5, packetsPair6,
                packetsPair7, packetsPair8));

        //When
        int sumOfPairsInRightOrderIndexes = givenPacketsPairInventory.computeSumOfPairsInRightOrderIndexes();

        //Then
        assertThat(sumOfPairsInRightOrderIndexes).isEqualTo(13);
    }

    @Test
    void computeDistressSignal_should_give_multiplication_of_the_indices_of_dividers_in_packets_correctly_ordered() {
        //Given
        PacketsPair packetsPair1 = new PacketsPair(new Packet("[1,1,3,1,1]"), new Packet("[1,1,5,1,1]"));
        PacketsPair packetsPair2 = new PacketsPair(new Packet("[[1],[2,3,4]]"), new Packet("[[1],4]"));
        PacketsPair packetsPair3 = new PacketsPair(new Packet("[9]"), new Packet("[[8,7,6]]"));
        PacketsPair packetsPair4 = new PacketsPair(new Packet("[[4,4],4,4]"), new Packet("[[4,4],4,4,4]"));
        PacketsPair packetsPair5 = new PacketsPair(new Packet("[7,7,7,7]"), new Packet("[7,7,7]"));
        PacketsPair packetsPair6 = new PacketsPair(new Packet("[]"), new Packet("[3]"));
        PacketsPair packetsPair7 = new PacketsPair(new Packet("[[[]]]"), new Packet("[[]]"));
        PacketsPair packetsPair8 = new PacketsPair(new Packet("[1,[2,[3,[4,[5,6,7]]]],8,9]"), new Packet("[1,[2,[3,[4,[5,6,0]]]],8,9]"));
        List<PacketsPair> packetsPairList = new ArrayList<>();
        packetsPairList.add(packetsPair1);
        packetsPairList.add(packetsPair2);
        packetsPairList.add(packetsPair3);
        packetsPairList.add(packetsPair4);
        packetsPairList.add(packetsPair5);
        packetsPairList.add(packetsPair6);
        packetsPairList.add(packetsPair7);
        packetsPairList.add(packetsPair8);

        PacketsPairInventory givenPacketsPairInventory = new PacketsPairInventory(packetsPairList);

        //When
        int sumOfPairsInRightOrderIndexes = givenPacketsPairInventory.computeDistressSignal();

        //Then
        assertThat(sumOfPairsInRightOrderIndexes).isEqualTo(140);
    }

}