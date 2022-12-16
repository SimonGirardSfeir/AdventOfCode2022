package org.example.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record PacketsPairInventory(List<PacketsPair> packetsPairs) {
    public static PacketsPairInventory of(List<String> lines) {
        List<PacketsPair> packetsPairs = new ArrayList<>();

        for(int i = 0; i <= lines.size(); i ++) {
            if((i+1) % 3 == 0) {
                PacketsPair packetsPair = new PacketsPair(new Packet(lines.get(i-2)), new Packet(lines.get(i-1)));
                packetsPairs.add(packetsPair);
            }
        }
        return new PacketsPairInventory(packetsPairs);
    }

    public int computeSumOfPairsInRightOrderIndexes() {
        int sumOfPairsInRightOrderIndexes = 0;

        for(int i = 0; i < packetsPairs.size(); i++) {
            if(packetsPairs.get(i).isInRightOrder())
                sumOfPairsInRightOrderIndexes += i + 1;
        }
        return sumOfPairsInRightOrderIndexes;
    }

    public int computeDistressSignal() {
        int distressSignal1 = 0;
        int distressSignal2 = 0;
        Packet distressPacket1 = new Packet("[[2]]");
        Packet distressPacket2 = new Packet("[[6]]");
        List<Packet> allPackets = packetsPairs.stream().map(PacketsPair::leftSide).collect(Collectors.toCollection(ArrayList::new));
        List<Packet> rightPackets = packetsPairs.stream().map(PacketsPair::rightSide).collect(Collectors.toCollection(ArrayList::new));

        allPackets.addAll(rightPackets);
        allPackets.add(distressPacket1);
        allPackets.add(distressPacket2);

        allPackets = allPackets.stream()
                .sorted()
                .toList();

        for(int i = 0; i < allPackets.size(); i++) {
            if(allPackets.get(i).equals(distressPacket1))
                distressSignal1 = i+1;
            if(allPackets.get(i).equals(distressPacket2))
                distressSignal2 = i+1;
        }

        return distressSignal1 * distressSignal2;
    }
}
