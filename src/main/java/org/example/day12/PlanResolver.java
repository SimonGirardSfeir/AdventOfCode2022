package org.example.day12;

import java.util.List;

public class PlanResolver {
    private PlanResolver(){
    }

    public static Plan getPlanFromLines(List<String> lines) {
        return Plan.of(lines);
    }

    public static boolean isReachable(char source, char target, boolean isReversePath) {
        /*
         *  Characters represent here elevation of the map.
         *  Except the one that represents starting point ('S') which is of elevation 'a'
         *  and the one that represents ending point ('E') which is of elevation 'z'.
         *  Here's why conversion above
         */
        if(source == 'E')
            source = 'z';
        if(target == 'E')
            target = 'z';
        if(source == 'S')
            source = 'a';
        if(target == 'S')
            target = 'a';
        if(isReversePath)
            return source - target < 2;
        else
            return target - source < 2;
    }
}
