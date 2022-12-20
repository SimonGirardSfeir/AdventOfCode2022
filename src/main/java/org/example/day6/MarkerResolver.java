package org.example.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MarkerResolver {
    private MarkerResolver() {
    }

    public static int getFirstMarker(String datastreamBuffer, int markerLength) {
        Set<Character> tempSet = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i <datastreamBuffer.length(); i++) {
            Character currentCharacter = datastreamBuffer.charAt(i);
            list.add(currentCharacter);
            tempSet.add(currentCharacter);

            if(i >= markerLength)
                removeNonRelevantCharactersForMarker(markerLength, tempSet, list, i);

            if(tempSet.size() == markerLength)
                return i+1;

        }
        return 0;
    }

    private static void removeNonRelevantCharactersForMarker(int markerLength, Set<Character> tempSet, 
                                                             List<Character> list, int i) {
        Character characterToRemove = list.get(i - markerLength);
        //Set is chosen because contains has better time complexity, O(1) vs O(n)
        Set<Character> subListSet = new HashSet<>(list.subList(i - markerLength + 1, i +1));
        if(!subListSet.contains(characterToRemove)) {
            tempSet.remove(characterToRemove);
        }
    }
}
