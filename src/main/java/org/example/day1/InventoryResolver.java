package org.example.day1;

import java.util.ArrayList;
import java.util.List;
public class InventoryResolver {
    private InventoryResolver() {
    }

    public static Inventory inventoryFromLine(List<String> lines) {
        List<FoodBag> foodBags = new ArrayList<>();
        Inventory inventory = new Inventory(foodBags);
        List<Integer> tempList = new ArrayList<>();
        for(String line : lines) {
            if (line.isBlank()) {
                FoodBag foodBag = new FoodBag(tempList);
                foodBags.add(foodBag);
                tempList = new ArrayList<>();
            } else {
                Integer i = Integer.valueOf(line);
                tempList.add(i);
            }
        }
        return inventory;
    }
}
