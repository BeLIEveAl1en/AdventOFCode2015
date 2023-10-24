package com.advent.day5;

public class Line {
    private final boolean threeVowels;
    private final boolean doubleLetter;
    private final boolean wrongCombination;

    public Line(boolean threeVowels, boolean doubleLetter, boolean wrongCombination) {
        this.threeVowels = threeVowels;
        this.doubleLetter = doubleLetter;
        this.wrongCombination = wrongCombination;
    }

    public boolean isThreeVowels() {
        return threeVowels;
    }

    public boolean isDoubleLetter() {
        return doubleLetter;
    }

    public boolean isWrongCombination() {
        return wrongCombination;
    }
}