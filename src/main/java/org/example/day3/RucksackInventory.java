package org.example.day3;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.day3.RucksackResolver.itemToPriorityMap;

public record RucksackInventory(List<Rucksack> rucksacks) {

    public int computeTotalPriority() {
        return rucksacks.stream()
                .map(Rucksack::getCommonItem)
                .map(itemToPriorityMap::get)
                .reduce(0, Integer::sum);
    }

    private Collection<List<Rucksack>> groupRucksacksByN(int groupSize) {
        return rucksacks.stream().collect(Collectors.groupingBy(r -> rucksacks.indexOf(r)/groupSize)).values();
    }

    public int computeTotalPriorityRucksacksGrouped(int groupSize) {
        return groupRucksacksByN(groupSize).stream()
                .map(list -> list.stream().map(rucksack -> rucksack.firstCompartment() + rucksack.secondCompartment()).toList())
                .map(RucksackResolver::getCommonItemBetweenLines)
                .map(itemToPriorityMap::get)
                .reduce(0, Integer::sum);
    }
}
