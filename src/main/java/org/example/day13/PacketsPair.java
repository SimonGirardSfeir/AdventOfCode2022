package org.example.day13;

public record PacketsPair(Packet leftSide, Packet rightSide) {
    public boolean isInRightOrder() {
        return leftSide.compareTo(rightSide) < 0;
    }
}
