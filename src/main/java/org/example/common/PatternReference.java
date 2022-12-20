package org.example.common;

import java.util.regex.Pattern;

public final class PatternReference {
    public static final Pattern INTEGER_REGEX = Pattern.compile("\\d+");
    private PatternReference() {
    }
}
