package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class DoubleLetterCriteria implements Criteria<String>{
    @Override
    public List<String> meetCriteria(List<String> lines) {
        List<String> selectedLines = new ArrayList<>();

        for (String line : lines){
            if (containsDoubleLetter(line)){
                selectedLines.add(line);
            }
        }
        return selectedLines;
    }

    private boolean containsDoubleLetter(String line){
        for (int i = 0; i < line.length() - 1; i++){
            if (line.charAt(i) == line.charAt(i + 1)){
                return true;
            }
        }
        return false;
    }
}
