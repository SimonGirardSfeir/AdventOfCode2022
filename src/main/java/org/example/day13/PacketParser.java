package org.example.day13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.day13.PacketChecking.isANumberList;

public final class PacketParser {
    private PacketParser(){
    }

    public static List<String> destructuringContent(String content) {
        content = removeBrackets(content);
        List<String> destructuredContent = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i< content.length(); i++) {
            char c = content.charAt(i);
            if(c == '[' && deque.isEmpty()){
                destructuredContent.add(temp.stream().map(String::valueOf).collect(Collectors.joining()));
                temp = new ArrayList<>();
                deque.add(i);
                temp.add(c);
            } else if(c == '[') {
                temp.add(c);
                deque.add(i);
            } else if(c == ']' && deque.size() == 1) {
                deque.pop();
                temp.add(c);
                destructuredContent.add(temp.stream().map(String::valueOf).collect(Collectors.joining()));
                temp = new ArrayList<>();
            } else if(content.charAt(i) == ']') {
                deque.pop();
                temp.add(c);
            } else {
                temp.add(c);
            }
        }
        destructuredContent.add(temp.stream().map(String::valueOf).collect(Collectors.joining()));
        destructuredContent = destructuredContent.stream()
                .filter(s -> !s.isBlank() && !",".equals(s))
                .map(PacketParser::cleanContent)
                .toList();

        List<String> reallyDestructured = new ArrayList<>();

        for(String destructuredString : destructuredContent) {
            if(isANumberList(destructuredString))
                reallyDestructured.addAll(Arrays.stream(destructuredString.split(","))
                        .toList());
            else
                reallyDestructured.add(destructuredString);
        }
        return reallyDestructured;
    }
    public static String addBrackets(String content) {
        return "["+content+"]";
    }
    public static String removeBrackets(String content) {
        return content.substring(1, content.length() - 1);
    }
    private static String cleanContent(String content) {
        String contentCleaned = content;
        if(contentCleaned.startsWith(","))
            contentCleaned = contentCleaned.substring(1);
        if(contentCleaned.endsWith(","))
            contentCleaned = contentCleaned.substring(0, contentCleaned.length()-1);
        return contentCleaned;
    }
}
