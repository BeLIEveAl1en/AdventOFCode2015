package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class DoubleLetterCriteria implements Criteria{
    @Override
    public List<Line> meetCriteria(List<Line> lines) {
        List<Line> doubleLetterCriteria = new ArrayList<>();

        for (Line line : lines){
            if (line.isDoubleLetter())
                doubleLetterCriteria.add(line);
        }

        return doubleLetterCriteria;
    }
}
