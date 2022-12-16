package org.example.day13;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.day13.PacketChecking.isANumber;
import static org.example.day13.PacketChecking.isANumberList;
import static org.example.day13.PacketChecking.isOnlyOneSideIsANumber;
import static org.example.day13.PacketParser.destructuringContent;

public record Packet(String content) implements Comparable<Packet> {
    @Override
    public int compareTo(Packet otherPacket) {
        AtomicInteger isGreater = new AtomicInteger(0);
        compare(content, otherPacket.content(), isGreater);
        return isGreater.get();
    }

    private void compare(String currentContent, String currentOther, AtomicInteger isGreater) {
        if(isGreater.get() != 0)
            return;
        if(isANumber(currentOther) && isANumber(currentContent)) {
            compareNumber(currentContent, currentOther, isGreater);
            return;
        }
        if(isOnlyOneSideIsANumber(currentContent, currentOther)) {
            setOneSideAsNumberList(currentContent, currentOther, isGreater);
            return;
        }


        List<String> destructuredContent = destructuringContent(currentContent);
        List<String> destructuredOtherContent = destructuringContent(currentOther);
        int minSize = Math.min(destructuredContent.size(), destructuredOtherContent.size());

        for(int i = 0; i < minSize; i++) {
            compare(destructuredContent.get(i), destructuredOtherContent.get(i), isGreater);
            if(isGreater.get() != 0)
                return;
        }

        if(destructuredContent.size() > destructuredOtherContent.size())
            isGreater.set(1);
        else if(destructuredContent.size() < destructuredOtherContent.size())
            isGreater.set(-1);
    }
    private void setOneSideAsNumberList(String left, String right, AtomicInteger isGreater) {
        if(isANumberList(left))
            left = PacketParser.addBrackets(left);
        else if(isANumberList(right))
            right = PacketParser.addBrackets(right);
        compare(left, right, isGreater);
    }
    private static void compareNumber(String left, String right, AtomicInteger isGreater) {
        int leftNumber = Integer.parseInt(left);
        int rightNumber = Integer.parseInt(right);
        if(leftNumber < rightNumber)
            isGreater.set(-1);
        else if (leftNumber > rightNumber)
            isGreater.set(1);

    }
}
