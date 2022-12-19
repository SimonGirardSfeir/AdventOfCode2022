package org.example.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RucksackResolver {
    public static final Map<Character, Integer> itemToPriorityMap = new HashMap<>();

    static {
        initializeItemToPriorityMap();
    }
    
    private RucksackResolver() {
    }

    private static void initializeItemToPriorityMap() {
        int counter = 1;
        for(char c = 'a'; c <= 'z'; c++) {
            itemToPriorityMap.put(c, counter);
            counter++;
        }
        for(char c = 'A'; c <= 'Z'; c++) {
            itemToPriorityMap.put(c, counter);
            counter++;
        }
    }
    public static RucksackInventory getRuckSackInventoryFromLines(List<String> lines) {
        List<Rucksack> rucksacks = new ArrayList<>();
        for(String line : lines) {
            Rucksack rucksack = Rucksack.of(line);
            rucksacks.add(rucksack);
        }
        return new RucksackInventory(rucksacks);
    }
    private static boolean allElementsContainItem(List<String> elements, Character item) {
        for(String element : elements) {
            if (element.indexOf(item) < 0) {
                return false;
            }
        }
        return true;
    }
    public static Character getCommonItemBetweenLines(List<String> lines) {
        return lines.get(0)
                .chars()
                .mapToObj(i -> (char)i)
                .filter(c -> allElementsContainItem(lines.stream().skip(1).toList(), c))
                .findFirst().orElse(null);
    }
}
