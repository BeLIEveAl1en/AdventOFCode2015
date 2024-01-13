package com.advent.day8;

public class ProcessLine {
    public int calculateFinalNumber(Line line){
        return line.getCharactersOfCode() - line.getCharactersInMemory();
    }


}
