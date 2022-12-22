package org.example.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.example.common.PatternReference.NOT_AN_INTEGER_REGEX;
import static org.example.day11.Operator.SQUARE;

public final class ZooResolver {
    private static final int NUMBER_OF_LINES_FOR_A_SINGLE_MONKEY_IN_FILE = 7;
    private static final Pattern MONKEY_ID_PATTERN = Pattern.compile("Monkey \\d+:");
    private static final Pattern ITEMS_PATTERN = Pattern.compile("Starting items: \\d+(, \\d+)*");
    private static final Pattern OPERATION_PATTERN = Pattern.compile("Operation: new = old ([*+]) (\\d+|old)");
    private static final Pattern TEST_DIVISIBLE_PATTERN = Pattern.compile("Test: divisible by \\d+");
    private static final Pattern DIVISIBLE_SUCCESS_PATTERN = Pattern.compile("If true: throw to monkey \\d+");
    private static final Pattern DIVISIBLE_FAILURE_PATTERN = Pattern.compile("If false: throw to monkey \\d+");
    private static final Pattern COMMA_SEPARATOR = Pattern.compile(", ");
    private ZooResolver(){
    }

    public static Zoo getMonkeysZooFromLines(List<String> lines, boolean isWeird) {
        List<Monkey> monkeys = new ArrayList<>();

        List<String> tempList = new ArrayList<>();
        for(int i = 0; i <= lines.size(); i++) {
            if((i+1) % NUMBER_OF_LINES_FOR_A_SINGLE_MONKEY_IN_FILE != 0) {
                tempList.add(lines.get(i));
            } else {
                Monkey monkey = getMonkeyFromLines(tempList, isWeird);
                monkeys.add(monkey);
                tempList = new ArrayList<>();
            }
        }
        return new Zoo(monkeys);
    }
    public static Monkey getMonkeyFromLines(List<String> lines, boolean isWeird) {
        int id = 0;
        List<Item> items = new ArrayList<>();
        int divisibleTest = 1;
        int targetMonkeyIfTestSuccess = 0;
        int targetMonkeyIfTestFails = 0;
        Operation operation = null;
        for(String line : lines) {
            if(MONKEY_ID_PATTERN.matcher(line).matches())
                id = getUniqueNumberFromLine(line);
            if(TEST_DIVISIBLE_PATTERN.matcher(line.trim()).matches())
                divisibleTest = getUniqueNumberFromLine(line);
            if(DIVISIBLE_SUCCESS_PATTERN.matcher(line.trim()).matches())
                targetMonkeyIfTestSuccess = getUniqueNumberFromLine(line);
            if(DIVISIBLE_FAILURE_PATTERN.matcher(line.trim()).matches())
                targetMonkeyIfTestFails = getUniqueNumberFromLine(line);
            if(OPERATION_PATTERN.matcher(line.trim()).matches())
                operation = getOperationFromLine(line);
            if(ITEMS_PATTERN.matcher(line.trim()).matches())
                items = getItemsFromLine(line);

        }
        if(isWeird) {
            return new WeirdMonkey(id, items, operation,
                    divisibleTest, targetMonkeyIfTestSuccess, targetMonkeyIfTestFails);
        } else {
            return new NormalMonkey(id, items, operation,
                    divisibleTest, targetMonkeyIfTestSuccess, targetMonkeyIfTestFails);
        }
    }
    private static int getUniqueNumberFromLine(String line) {
        return Integer.parseInt(NOT_AN_INTEGER_REGEX.matcher(line).replaceAll(""));
    }

    public static List<Item> getItemsFromLine(String line) {
        String interestingPartOfLine = line.replace("Starting items: ","").trim();
        return Arrays.stream(COMMA_SEPARATOR.split(interestingPartOfLine))
                .map(itemAsString -> new Item(Long.parseLong(itemAsString)))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Operation getOperationFromLine(String line) {
        String interestingPartOfLine = line.replace("Operation: new = ", "").trim();
        String[] splitLine = interestingPartOfLine.split(" ");
        int operand;
        Operator operator;
        if("old".equals(splitLine[2])) {
            operand = 2;
            operator = SQUARE;
        } else {
            operand = Integer.parseInt(splitLine[2]);
            operator = Operator.valueOfLabel(splitLine[1]);
        }
        return new Operation(operand, operator);
    }
}
