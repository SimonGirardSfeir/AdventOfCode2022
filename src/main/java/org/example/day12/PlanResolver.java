package org.example.day12;

import java.util.List;

public class PlanResolver {
    private PlanResolver(){
    }

    public static Plan getPlanFromLines(List<String> lines) {
        return Plan.of(lines);
    }
}
