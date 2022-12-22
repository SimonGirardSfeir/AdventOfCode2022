package org.example.day11;

import java.util.List;

public class NormalMonkey extends Monkey {
    private static final int WORRY_LEVEL_DIVIDER = 3;
    public NormalMonkey(int id, List<Item> items, Operation operation, int divisibleTest,
                        int targetMonkeyIfTestSuccess, int targetMonkeyIfTestFails) {
        super(id, items, operation, divisibleTest, targetMonkeyIfTestSuccess, targetMonkeyIfTestFails);
    }

    @Override
    protected long affectWorryLevel(long worryLevel, Operation operation, long monkeysDivisibilityCheckLCM) {
        return switch (operation.operator()) {
            case ADDITION -> (worryLevel + operation.operand())/WORRY_LEVEL_DIVIDER;
            case MULTIPLICATION -> (worryLevel * operation.operand())/WORRY_LEVEL_DIVIDER;
            case SQUARE -> (worryLevel * worryLevel)/WORRY_LEVEL_DIVIDER;
        };
    }
}
