package org.example.day11;

import java.util.List;

public class NormalMonkey extends Monkey {
    public NormalMonkey(int id, List<Item> items, Operation operation, int divisibleTest, int targetMonkeyIfTestSuccess, int targetMonkeyIfTestFails) {
        super(id, items, operation, divisibleTest, targetMonkeyIfTestSuccess, targetMonkeyIfTestFails);
    }

    public static NormalMonkey of(List<String> lines) {
        int[] monkeyParameters = getMonkeyParameters(lines);
        return new NormalMonkey(monkeyParameters[0], Item.of(lines.get(1)), Operation.of(lines.get(2)),
                monkeyParameters[1], monkeyParameters[2], monkeyParameters[3]);
    }

    @Override
    protected long affectWorryLevel(long worryLevel, Operation operation, long monkeysDivisibilityCheckLCM) {
        if(Operator.ADDITION.equals(operation.operator()))
            worryLevel = (worryLevel + operation.operand())/3;
        else if(Operator.MULTIPLICATION.equals(operation.operator()))
            worryLevel = (worryLevel * operation.operand())/3;
        else if(Operator.SQUARE.equals(operation.operator()))
            worryLevel = (worryLevel * worryLevel)/3;
        return worryLevel;
    }
}
