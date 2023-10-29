package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class RepetitiveLettersCriteria implements Criteria<String>{

    @Override
    public List<String> meetCriteria(List<String> lines) {
        List<String> selectedLines = new ArrayList<>();

        for (String line : lines){
            if (containsRepetitiveLetters(line)){
                selectedLines.add(line);
            }
        }
        return selectedLines;
    }

    private boolean containsRepetitiveLetters(String line){
        for (int i = 0; i < line.length() - 2; i++){
            if (line.charAt(i) == line.charAt(i + 2)){
                return true;
            }
        }
        return false;
    }
}
