package org.example.day4;

public record Section(int start, int end) {
    public static Section of(Integer[] limits) {
        return new Section(limits[0],limits[1]);
    }
}
