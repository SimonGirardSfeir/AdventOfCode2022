package org.example.day13;

import static org.example.common.PatternReference.INTEGER_REGEX;

public final class PacketChecking {
    private PacketChecking(){
    }

    public static boolean isOnlyOneSideIsANumber(String left, String right) {
        return (isANumberList(left) && !isANumberList(right)) ||
                (!isANumberList(left) && isANumberList(right));
    }
    public static boolean isANumberList(String content) {
        return !content.contains("[") && !content.contains("]");
    }
    public static boolean isANumber(String content) {
        return INTEGER_REGEX.matcher(content).matches();
    }
}
