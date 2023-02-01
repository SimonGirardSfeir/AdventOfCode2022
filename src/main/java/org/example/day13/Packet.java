package org.example.day13;

import java.util.List;

import static org.example.day13.PacketChecking.isANumber;
import static org.example.day13.PacketChecking.isANumberList;
import static org.example.day13.PacketChecking.isOnlyOneSideIsANumber;
import static org.example.day13.PacketParser.destructuringContent;

public record Packet(String content) implements Comparable<Packet> {
    @Override
    public int compareTo(Packet otherPacket) {
        return comparePacketContent(content, otherPacket.content());
    }

    private int comparePacketContent(String currentContent, String currentOther) {
        int compareValue = 0;
        if(isANumber(currentOther) && isANumber(currentContent)) {
            compareValue =  compareNumber(currentContent, currentOther);

        } else if(isOnlyOneSideIsANumber(currentContent, currentOther)) {
            compareValue = setOneSideAsNumberList(currentContent, currentOther);

        } else {
            List<String> destructuredContent = destructuringContent(currentContent);
            List<String> destructuredOtherContent = destructuringContent(currentOther);
            int minSize = Math.min(destructuredContent.size(), destructuredOtherContent.size());

            for(int i = 0; i < minSize; i++) {
                int compared = comparePacketContent(destructuredContent.get(i), destructuredOtherContent.get(i));
                if(compared != 0) {
                    compareValue =  compared;
                    break;
                }
            }

            if(compareValue == 0)
                compareValue = Integer.compare(destructuredContent.size(), destructuredOtherContent.size());
        }
        return compareValue;
    }
    private int setOneSideAsNumberList(String left, String right) {
        if(isANumberList(left))
            left = PacketParser.addBrackets(left);
        else
            right = PacketParser.addBrackets(right);
        return comparePacketContent(left, right);
    }
    private static int compareNumber(String left, String right) {
        int leftNumber = Integer.parseInt(left);
        int rightNumber = Integer.parseInt(right);
        return  Integer.compare(leftNumber, rightNumber);
    }
}
