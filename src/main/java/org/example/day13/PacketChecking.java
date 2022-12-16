package org.example.day13;

public class PacketChecking {
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
        return content.matches("^\\d+$");
    }
}
