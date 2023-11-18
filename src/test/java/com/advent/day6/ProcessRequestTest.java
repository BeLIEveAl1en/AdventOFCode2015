package com.advent.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class ProcessRequestTest {
    @Test
    public void shouldFindCoordinatesInRequest(){
        int[] expected = {1, 2, 3, 4};
        String req = "turn off 1,2 through 3,4";
        ProcessRequest processRequest = new ProcessRequest();
        Assertions.assertEquals(expected[3], processRequest.findCoordinates(req)[3]);
    }

    @Test
    public void shouldFindCommandInRequest(){
        String expected = "turn off ";
        String req = "turn off 1,2 through 3,4";
        ProcessRequest processRequest = new ProcessRequest();
        Assertions.assertEquals(expected, processRequest.findCommandInRequest(req));
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
    turn on 0,0 through 1,1 | 4 | 2 | 2
    toggle 0,0 through 2,2| 18 | 3 | 3
    turn on 0,0 through 3,3|  16 | 4 | 4
    turn on 1,1 through 2,2 | 4 | 3 | 3
    turn on 0,0 through 0,0 | 1 | 3 | 3
    turn on 499,499 through 500,500 | 4 | 1000 | 1000
    toggle 0,0 through 999,999 | 2_000_000 | 1000 | 1000
    turn on 0,0 through 999,999 | 1_000_000 | 1000 | 1000
    """)
    public void shouldProcessRequest(String input, int expected, int width, int height){
        GridOfLamps grid = new GridOfLamps(width, height);
        ProcessRequest processRequest = new ProcessRequest();
        processRequest.processRequest(grid, input);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
    [turn on 0,0 through 1,1, turn off 0,0 through 0,1] | 2 | 2 | 2
    """)
    public void shouldProcessListOfRequest(List<String> input, int expected, int width, int height){
        GridOfLamps grid = new GridOfLamps(width, height);
        ProcessRequest processRequest = new ProcessRequest();
        processRequest.processListOfRequest(grid, input);
        Assertions.assertEquals(expected, grid.countLamps());
    }
}
