package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class WrongCombinationCriteria implements Criteria{
    @Override
    public List<Line> meetCriteria(List<Line> lines) {
        List<Line> wrongCombinationCriteria = new ArrayList<>();

        for (Line line : lines){
            if (line.isWrongCombination())
                wrongCombinationCriteria.add(line);
        }

        return wrongCombinationCriteria;
    }
}
