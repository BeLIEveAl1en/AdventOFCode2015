package com.advent.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProcessRequestTest {
    @Test
    public void shouldFindCoordinatesInRequest(){
        int[] expected = {1, 2, 3, 4};
        String req = "turn off 1,2 through 3,4";
        ProcessRequest processRequest = new ProcessRequest();
        Assertions.assertEquals(expected, processRequest.findCoordinates(req));
    }
}
