package org.example.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Resolver {

    private Resolver() {
    }
    public static List<String> getLines(String fileName) throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.toList();
        }
    }
    public static Inventory inventoryFromLine(List<String> lines) {
        List<FoodBag> foodBags = new ArrayList<>();
        Inventory inventory = new Inventory(foodBags);
        List<Integer> tempList = new ArrayList<>();
        for(String line : lines) {
            if(!line.isBlank()) {
                Integer i = Integer.valueOf(line);
                tempList.add(i);
            } else {
                FoodBag foodBag = new FoodBag(tempList);
                foodBags.add(foodBag);
                tempList = new ArrayList<>();
            }
        }
        return inventory;
    }
}
