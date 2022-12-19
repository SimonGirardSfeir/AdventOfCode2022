package org.example.day14;

import java.util.List;

public final class CaveResolver {
    private CaveResolver(){
    }

    public static Cave getCaveFromLines(List<String> lines) {
        return Cave.of(lines);
    }
}
