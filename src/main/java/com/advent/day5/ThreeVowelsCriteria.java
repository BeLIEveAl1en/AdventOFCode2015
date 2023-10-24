package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class ThreeVowelsCriteria implements Criteria {

    @Override
    public List<Line> meetCriteria(List<Line> lines) {
        List<Line> threeVowelsCriteria = new ArrayList<>();

        for (Line line : lines){
            if (line.isThreeVowels())
                threeVowelsCriteria.add(line);
        }

        return threeVowelsCriteria;
    }
}
