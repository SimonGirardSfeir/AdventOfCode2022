package org.example.day15;

import java.util.Objects;

public final class CoveredZone implements Comparable<CoveredZone> {
    private  int min;
    private  int max;

    public CoveredZone(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getLength() {
        return max - min + 1;
    }
    public void mergeCoveredZone(CoveredZone otherCoveredZone) {
        if (otherCoveredZone != null) {
            min = Math.min(min, otherCoveredZone.min);
            max = Math.max(max, otherCoveredZone.max);
        }
    }
    public boolean areCoveredZoneDisjoints(CoveredZone coveredZone) {
        return (max + 1 < coveredZone.min) || (coveredZone.max + 1 < min);
    }

    public int getMin() {
        return min;
    }
    public int getMax() {
        return max;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public int compareTo(CoveredZone o) {
        return min - o.min;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (CoveredZone) obj;
        return this.min == that.min && this.max == that.max;
    }
    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

}
