package com.advent.day5;

import java.util.ArrayList;
import java.util.List;

public class ThreeVowelsCriteria implements Criteria<String> {

    @Override
    public List<String> meetCriteria(List<String> lines) {
        List<String> selectedLines = new ArrayList<>();

        for (String line : lines){
            if (containsThreeVowels(line)){
                selectedLines.add(line);
            }
        }

        return selectedLines;
    }
    
    private boolean containsThreeVowels(String line){
        int countOfVowels = 0;

        for (char symbol : line.toCharArray()){
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                countOfVowels++;
            }
        }

        return countOfVowels >=  3;
    } 
}
