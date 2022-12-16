package org.example.day13;

import java.util.List;

public class PacketsPairResolver {
    private PacketsPairResolver(){
    }

    public static PacketsPairInventory getPacketsPairInventoryFromLines(List<String> lines) {
        return PacketsPairInventory.of(lines);
    }
}
