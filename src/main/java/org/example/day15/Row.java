package org.example.day15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public record Row(List<CoveredZone> coveredZones, int lowerLimit, int upperLimit) {
    public Row() {
        this(new ArrayList<>(), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public Row(int upperLimit) {
        this(new ArrayList<>(), 0, upperLimit);
    }

    public void addCoveredZone(CoveredZone coveredZone) {
        coveredZone.setMin(Math.max(coveredZone.getMin(), lowerLimit));
        coveredZone.setMax(Math.min(coveredZone.getMax(), upperLimit));
        for(Iterator<CoveredZone> iterator = coveredZones.iterator(); iterator.hasNext(); ) {
            CoveredZone currentCoveredZone = iterator.next();
            if (!currentCoveredZone.areCoveredZoneDisjoints(coveredZone)) {
                coveredZone.mergeCoveredZone(currentCoveredZone);
                iterator.remove();
            }
        }
        coveredZones.add(coveredZone);
    }
    public int getFreePositionInRow() {
        if(coveredZones.size() != 2)
            throw new NoSuchElementException();
        List<CoveredZone> orderedList = coveredZones.stream().sorted().toList();

        int freePosition = orderedList.get(0).getMax() + 1;

        if(freePosition < lowerLimit || freePosition > upperLimit)
            throw new NoSuchElementException();

        return freePosition;
    }
    public boolean isFull() {
        return coveredZones.size() == 1 && coveredZones.get(0).equals(new CoveredZone(lowerLimit, upperLimit));
    }
}
