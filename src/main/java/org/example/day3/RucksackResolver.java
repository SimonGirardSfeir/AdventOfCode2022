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
        return elements.stream()
                .allMatch(element -> element.contains(item.toString()));
    }
    public static Character getCommonItemBetweenLines(List<String> lines) {
        return lines.getFirst()
                .chars()
                .mapToObj(i -> (char)i)
                .filter(c -> allElementsContainItem(lines.stream().skip(1).toList(), c))
                .findFirst().orElse(null);
    }
}
