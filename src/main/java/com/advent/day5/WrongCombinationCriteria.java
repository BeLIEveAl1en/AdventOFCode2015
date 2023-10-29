package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class WrongCombinationCriteria implements Criteria<String> {
    @Override
    public List<String> meetCriteria(List<String> lines) {
        List<String> selectedLines = new ArrayList<>();

        for (String line : lines){
            if (!containsWrongCombination(line)){
                selectedLines.add(line);
            }
        }

        return selectedLines;
    }

    private boolean containsWrongCombination(String line) {
        return line.contains("xy") || line.contains("ab") || line.contains("cd") || line.contains("pq");
    }
}
