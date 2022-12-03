package org.example.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RucksackResolver {
    static Map<Character, Integer> itemToPriorityMap = getItemToPriorityMap();
    
    private RucksackResolver() {
    }

    private static Map<Character, Integer> getItemToPriorityMap() {
        itemToPriorityMap = new HashMap<>();
        int counter = 1;
        for(char c = 'a'; c <= 'z'; c++) {
            itemToPriorityMap.put(c, counter);
            counter++;
        }
        for(char c = 'A'; c <= 'Z'; c++) {
            itemToPriorityMap.put(c, counter);
            counter++;
        }
        return itemToPriorityMap;
    }
    public static RucksackInventory getRuckSackInventoryFromLines(List<String> lines) {
        List<Rucksack> rucksacks = new ArrayList<>();
        for(String line : lines) {
            Rucksack rucksack = Rucksack.of(line);
            rucksacks.add(rucksack);
        }
        return new RucksackInventory(rucksacks);
    }
    private static boolean allElementsContainsItem(List<String> elements, Character item) {
        boolean output = true;
        for(String element : elements) {
            if (element.indexOf(item) < 0) {
                output = false;
                break;
            }
        }
        return output;
    }
    public static Character getCommonItemBetweenLines(List<String> lines) {
        return lines.get(0)
                .chars()
                .mapToObj(i -> (char)i)
                .filter(c -> allElementsContainsItem(lines.stream().skip(1).toList(), c))
                .findFirst().orElse(null);
    }
}
