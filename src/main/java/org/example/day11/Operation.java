package org.example.day11;

import static org.example.day11.Operator.SQUARE;

public record Operation(int operand, Operator operator) {
    public static Operation of(String line) {
        String interestingPartOfLine = line.substring(23);
        String[] splitLine = interestingPartOfLine.split(" ");
        int operand;
        Operator operator;
        if("old".equals(splitLine[1])) {
            operand = 2;
            operator = SQUARE;
        }
        else {
            operand = Integer.parseInt(splitLine[1]);
            operator = Operator.valueOfLabel(splitLine[0]);
        }
        return new Operation(operand, operator);
    }
}
