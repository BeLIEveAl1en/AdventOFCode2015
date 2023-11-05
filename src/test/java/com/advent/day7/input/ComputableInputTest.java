package com.advent.day7.input;

import com.advent.day7.UInt16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputableInputTest {
    @Test
    public void shouldBeReady(){
        ComputableInput input = new ComputableInput("x");
        input.setValue(new UInt16(12));
        Assertions.assertTrue(input.isReady());
    }

    @Test
    public void shouldNotBeReady(){
        ComputableInput input = new ComputableInput("x");
        Assertions.assertFalse(input.isReady());
    }

    @Test
    public void shouldReturnName(){
        String name = "x";
        ComputableInput input = new ComputableInput(name);
        Assertions.assertEquals(name, input.getName());
    }

    @Test
    public void shouldThrowWhenGetUnreadyValue(){
        ComputableInput input = new ComputableInput("x");
        Assertions.assertThrows(IllegalStateException.class, input::getValue);
    }

    @Test
    public void shouldReturnValue(){
        UInt16 expectedValue = new UInt16(12);
        ComputableInput input = new ComputableInput("x");
        input.setValue(expectedValue);
        Assertions.assertEquals(expectedValue, input.getValue());
    }
}
