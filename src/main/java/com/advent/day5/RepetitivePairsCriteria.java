package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class RepetitivePairsCriteria implements Criteria<String>{

    @Override
    public List<String> meetCriteria(List<String> lines) {
        List<String> selectedLines = new ArrayList<>();

        for (String line : lines){
            if (containsRepetitivePairs(line)){
                selectedLines.add(line);
            }
        }
        return selectedLines;
    }

    private boolean containsRepetitivePairs(String line){
        for (int i = 0; i < line.length() - 1; i++){
            String currentPair = line.substring(i, i + 2);
            String uncheckedLine = line.substring(i + 2);
            if (uncheckedLine.contains(currentPair)){
                return true;
            }
        }
        return false;
    }
}
