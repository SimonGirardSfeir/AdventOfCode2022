package org.example.day11;

import java.util.List;

public class WeirdMonkey extends Monkey {
    public WeirdMonkey(int id, List<Item> items, Operation operation, long divisibleTest,
                       int targetMonkeyIfTestSuccess, int targetMonkeyIfTestFails) {
        super(id, items, operation, divisibleTest, targetMonkeyIfTestSuccess, targetMonkeyIfTestFails);
    }

    @Override
    protected long affectWorryLevel(long worryLevel, long monkeysDivisibilityCheckLCM) {
        return switch (operation.operator()) {
            case ADDITION -> (worryLevel + operation.operand()) % monkeysDivisibilityCheckLCM;
            case MULTIPLICATION -> (worryLevel * operation.operand()) % monkeysDivisibilityCheckLCM;
            case SQUARE -> (worryLevel * worryLevel) % monkeysDivisibilityCheckLCM;
        };
    }
}
