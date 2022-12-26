package org.example.common;

import java.util.regex.Pattern;

public final class PatternReference {
    public static final Pattern INTEGER_REGEX = Pattern.compile("\\d+");
    public static final Pattern NOT_AN_INTEGER_REGEX = Pattern.compile("\\D");
    public static final Pattern NEW_LINE_PATTERN = Pattern.compile("\\n");
    private PatternReference() {
    }
}
