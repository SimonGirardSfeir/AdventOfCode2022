package org.example.day6;

import java.util.HashSet;
import java.util.Set;

public class MarkerResolver {
    private MarkerResolver() {
    }

    public static int getFirstMarker(String datastreamBuffer, int markerLength) {
        Set<Character> tempSet = new HashSet<>();
        for(int i = 0; i <datastreamBuffer.length() - markerLength; i++) {
            for(int j = i; j < i+markerLength; j++) {
                tempSet.add(datastreamBuffer.charAt(j));
            }
            if(tempSet.size() == markerLength) {
                return i+markerLength;
            } else {
                tempSet = new HashSet<>();
            }

        }
        return 0;
    }
}
