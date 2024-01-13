package com.advent.day8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LineTest {
    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            "abc" | 5 | 3
            "" | 2 | 0
            "aaa\"aaa" | 10 | 7
            """)
    public void shouldCalculateSumOfCharactersOfCodeAndSumOfMemoryOfCode(String input, int expectedSumOfCharactersOfCode, int expectedSumOfCMemoryOfCode){
        Line line = new Line(input);
        Assertions.assertEquals(expectedSumOfCharactersOfCode , line.getCharactersOfCode());
        Assertions.assertEquals(expectedSumOfCMemoryOfCode, line.getCharactersInMemory());
    }
}
