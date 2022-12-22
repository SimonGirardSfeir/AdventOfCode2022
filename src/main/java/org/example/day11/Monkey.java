package org.example.day11;

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
        this.items = items;
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

        worryLevel = affectWorryLevel(worryLevel, operation, monkeysDivisibilityCheckLCM);

        return worryLevel;
    }

    protected abstract long affectWorryLevel(long worryLevel, Operation operation, long monkeysDivisibilityCheckLCM);
    public int id() {
        return id;
    }

    public List<Item> items() {
        return items;
    }

    public long divisibleTest() {
        return divisibleTest;
    }

    public int targetMonkeyIfTestSuccess() {
        return targetMonkeyIfTestSuccess;
    }

    public int targetMonkeyIfTestFails() {
        return targetMonkeyIfTestFails;
    }

    public long numberOfItemsInspected() {
        return numberOfItemsInspected;
    }
}
