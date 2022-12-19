package org.example.day13;

import java.util.ArrayList;
import java.util.List;

public final class PacketsPairResolver {
    private static final int PACKET_PAIR_NUMBER_OF_LINES_IN_FILE = 3;
    private PacketsPairResolver(){
    }

    public static PacketsPairInventory getPacketsPairInventoryFromLines(List<String> lines) {
        List<PacketsPair> packetsPairs = new ArrayList<>();

        for(int i = 0; i <= lines.size(); i ++) {
            if((i+1) % PACKET_PAIR_NUMBER_OF_LINES_IN_FILE == 0) {
                PacketsPair packetsPair = new PacketsPair(new Packet(lines.get(i-2)), new Packet(lines.get(i-1)));
                packetsPairs.add(packetsPair);
            }
        }
        return new PacketsPairInventory(packetsPairs);
    }
}
