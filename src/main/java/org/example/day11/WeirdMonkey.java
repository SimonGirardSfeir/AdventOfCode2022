package org.example.day11;

import java.util.List;

public class WeirdMonkey extends Monkey {
    public WeirdMonkey(int id, List<Item> items, Operation operation, long divisibleTest,
                       int targetMonkeyIfTestSuccess, int targetMonkeyIfTestFails) {
        super(id, items, operation, divisibleTest, targetMonkeyIfTestSuccess, targetMonkeyIfTestFails);
    }

    public static WeirdMonkey of(List<String> lines) {
        int[] monkeyParameters = getMonkeyParameters(lines);
        return new WeirdMonkey(monkeyParameters[0], Item.of(lines.get(1)), Operation.of(lines.get(2)),
                monkeyParameters[1], monkeyParameters[2], monkeyParameters[3]);
    }

    @Override
    protected long affectWorryLevel(long worryLevel, Operation operation, long monkeysDivisibilityCheckLCM) {
        return switch (operation.operator()) {
            case ADDITION -> (worryLevel + operation.operand()) % monkeysDivisibilityCheckLCM;
            case MULTIPLICATION -> (worryLevel * operation.operand()) % monkeysDivisibilityCheckLCM;
            case SQUARE -> (worryLevel * worryLevel) % monkeysDivisibilityCheckLCM;
        };
    }
}
