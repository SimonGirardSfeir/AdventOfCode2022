package org.example.day11;

import org.example.exception.InvalidDataFromFile;

import java.util.ArrayList;
import java.util.List;

public abstract class Monkey {
    private final int id;
    private final List<Item> items;
    protected final Operation operation;
    private final long divisibleTest;
    private final int targetMonkeyIfTestSuccess;
    private final int targetMonkeyIfTestFails;
    private int numberOfItemsInspected;

    protected Monkey(int id, List<Item> items, Operation operation, long divisibleTest,
                  int targetMonkeyIfTestSuccess, int targetMonkeyIfTestFails) {
        this.id = id;
        this.items = new ArrayList<>(items);
        this.operation = operation;
        this.divisibleTest = divisibleTest;
        this.targetMonkeyIfTestSuccess = targetMonkeyIfTestSuccess;
        this.targetMonkeyIfTestFails = targetMonkeyIfTestFails;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public long computeWorryLevel(Item item, long monkeysDivisibilityCheckLCM) {
        numberOfItemsInspected++;
        long worryLevel = item.worryLevel();

        worryLevel = affectWorryLevel(worryLevel, monkeysDivisibilityCheckLCM);

        return worryLevel;
    }
    void performRoundOnMonkey(long monkeysDivisibilityCheckLCM,  List<Monkey> monkeysToConsider) {
        for(Item item : items) {
            long worryLevel = computeWorryLevel(item, monkeysDivisibilityCheckLCM);

            Monkey targetMonkey;
            if(worryLevel % divisibleTest == 0) {
                targetMonkey = monkeysToConsider.stream().filter(m -> m.id == targetMonkeyIfTestSuccess)
                        .findFirst().orElseThrow(InvalidDataFromFile::new);
            } else {
                targetMonkey = monkeysToConsider.stream().filter(m -> m.id == targetMonkeyIfTestFails)
                        .findFirst().orElseThrow(InvalidDataFromFile::new);
            }
            targetMonkey.addItem(new Item(worryLevel));
        }
        items.clear();
    }
    protected abstract long affectWorryLevel(long worryLevel, long monkeysDivisibilityCheckLCM);
    public long divisibleTest() {
        return divisibleTest;
    }
    public long numberOfItemsInspected() {
        return numberOfItemsInspected;
    }
}
