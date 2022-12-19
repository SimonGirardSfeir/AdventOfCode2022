package org.example.day11;

import java.util.ArrayList;
import java.util.List;

public final class ZooResolver {

    private static final int NUMBER_OF_LINES_FOR_A_SINGLE_MONKEY_IN_FILE = 7;
    private ZooResolver(){
    }

    public static Zoo getNormalMonkeysZooFromLines(List<String> lines) {
        List<Monkey> monkeys = new ArrayList<>();

        List<String> tempList = new ArrayList<>();
        for(int i = 0; i <= lines.size(); i++) {
            if((i+1) % NUMBER_OF_LINES_FOR_A_SINGLE_MONKEY_IN_FILE != 0) {
                tempList.add(lines.get(i));
            } else {
                Monkey monkey = NormalMonkey.of(tempList);
                monkeys.add(monkey);
                tempList = new ArrayList<>();
            }
        }
        return new Zoo(monkeys);
    }

    public static Zoo getWeirdMonkeysZooFromLines(List<String> lines) {
        List<Monkey> monkeys = new ArrayList<>();

        List<String> tempList = new ArrayList<>();
        for(int i = 0; i <= lines.size(); i++) {
            if((i+1) % NUMBER_OF_LINES_FOR_A_SINGLE_MONKEY_IN_FILE != 0) {
                tempList.add(lines.get(i));
            } else {
                Monkey monkey = WeirdMonkey.of(tempList);
                monkeys.add(monkey);
                tempList = new ArrayList<>();
            }
        }
        return new Zoo(monkeys);
    }
}
