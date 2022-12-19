package org.example.day13;

import java.util.regex.Pattern;

public final class PacketChecking {
    private static final Pattern integerRegex = Pattern.compile("^\\d+$");
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
        return integerRegex.matcher(content).matches();
    }
}
