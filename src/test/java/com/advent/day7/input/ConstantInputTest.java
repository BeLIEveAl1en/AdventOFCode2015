package com.advent.day7.input;

import com.advent.day7.UInt16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstantInputTest {
    @Test
    public void shouldBeReady(){
        ConstantInput input = new ConstantInput(12);
        Assertions.assertTrue(input.isReady());
    }

    @Test
    public void shouldReturnValue(){
        int expectedValue = 43;
        ConstantInput constantValue = new ConstantInput(expectedValue);
        Assertions.assertEquals(new UInt16(expectedValue), constantValue.getValue());
    }
}
