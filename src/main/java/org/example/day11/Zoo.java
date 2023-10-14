package org.example.day11;

import org.example.exception.InvalidDataFromFile;

import java.util.Comparator;
import java.util.List;

public record Zoo(List<Monkey> monkeys) {

    public void performRound(long monkeysDivisibilityCheckLCM) {
        monkeys.forEach(monkey -> performRoundOnMonkey(monkey, monkeysDivisibilityCheckLCM));
    }

    private void performRoundOnMonkey(Monkey monkey, long monkeysDivisibilityCheckLCM) {
        for(Item item : monkey.items()) {
            long worryLevel = monkey.computeWorryLevel(item, monkeysDivisibilityCheckLCM);

            Monkey targetMonkey;
            if(worryLevel % monkey.divisibleTest() == 0) {
                targetMonkey = monkeys().stream().filter(m -> m.id() == monkey.targetMonkeyIfTestSuccess())
                        .findFirst().orElseThrow(InvalidDataFromFile::new);
            } else {
                targetMonkey = monkeys().stream().filter(m -> m.id() == monkey.targetMonkeyIfTestFails())
                        .findFirst().orElseThrow(InvalidDataFromFile::new);
            }
            targetMonkey.addItem(new Item(worryLevel));
        }
        monkey.items().removeAll(monkey.items());
    }

    public long computeMonkeyBusiness(int numberOfRounds) {
        /*
         * Why this use of monkeysLCM here that can be seen as unexpected?
         *
         * In part 1, afet each item inspection, we use to divide it by 3 to have
         * acceptable worryLevel. We don't have this anymore in part 2.
         *
         * We should maintain an acceptable worryLevel (not too high) for a very high number of rounds and,
         * also we don't want to modify the outcome of divisibility check in each round.
         *
         * Assume X is the current worryLevel of the Item, B the value of divisibility check by Monkey 1,
         * C the value of divisibility check by Monkey 2. B and C are prime numbers.
         * Here, D = B*C is the least common multiplicative of B and C.
         *
         * If X % B = 0 and X % C = 0, then X % D = 0 (and same for non divisibility)
         *
         * So we can perform here the operation X = X % D to keep acceptable value for item's worryLevel and
         * not changing outcome of divisibility check.
         *
         */
        List<Long> monkeysDivisibilityChecks = monkeys().stream().map(Monkey::divisibleTest).toList();
        final long monkeysDivisibilityCheckLCM =
                findLeastCommonMultiplicativeOfMonkeysDivisibilityCheck(monkeysDivisibilityChecks);
        int counter = numberOfRounds;
        while(counter > 0) {
            performRound(monkeysDivisibilityCheckLCM);
            counter--;
        }

        return monkeys().stream()
                .sorted(Comparator.comparing(Monkey::numberOfItemsInspected).reversed())
                .map(Monkey::numberOfItemsInspected)
                .limit(2L)
                .reduce(1L, (a, b) -> a * b);
    }

    private static long findLeastCommonMultiplicativeOfMonkeysDivisibilityCheck(List<Long> divisibilityChecks) {
        long firstDivisibilityCheck = divisibilityChecks.getFirst();
        for(int i = 1; i < divisibilityChecks.size(); i++) {
            firstDivisibilityCheck = findLeastCommonMultiplicative(firstDivisibilityCheck, divisibilityChecks.get(i));
        }
        return firstDivisibilityCheck;
    }
    private static long findLeastCommonMultiplicative(long number1, long number2) {
        if (number1 == 0 || number2 == 0) {
            return 0;
        }
        long absNumber1 = Math.abs(number1);
        long absNumber2 = Math.abs(number2);
        long absHigherNumber = Math.max(absNumber1, absNumber2);
        long absLowerNumber = Math.min(absNumber1, absNumber2);
        long lcm = absHigherNumber;
        while (lcm % absLowerNumber != 0) {
            lcm += absHigherNumber;
        }
        return lcm;
    }
}
