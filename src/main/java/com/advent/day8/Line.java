package com.advent.day8;

public class Line {
    private final String line;
    private final int charactersOfCode;
    private int charactersInMemory;

    public Line(String line) {
        this.line = line;
        this.charactersOfCode = this.line.length();
        this.charactersInMemory = this.line.length() - 2;
    }

    public String getLine() {
        return line;
    }

    public void setCharactersInMemory(int charactersInMemory) {
        this.charactersInMemory = charactersInMemory;
    }

    public int getCharactersOfCode() {
        return charactersOfCode;
    }

    public int getCharactersInMemory() {
        return charactersInMemory;
    }
}
