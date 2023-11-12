package com.advent.day7;

import com.advent.day7.input.ComputableInput;
import com.advent.day7.input.ConstantInput;
import com.advent.day7.operator.Initialise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InitialiseTest {
    @Test
    public void shouldBeReadyWhenInputsReady(){
        ConstantInput arg1 = new ConstantInput(12);
        Initialise initialise = new Initialise(arg1);
        Assertions.assertTrue(initialise.isReady());
    }

    @Test
    public void shouldBeInitialiseReadyWhenInputsInitialiseReady(){
        ComputableInput arg1 = new ComputableInput("x");
        Initialise initialise = new Initialise(arg1);
        Assertions.assertFalse(initialise.isReady());
    }

    @Test
    public void shouldExecute(){
        UInt16 expectedResult = new UInt16(123);
        ConstantInput arg1 = new ConstantInput(123);
        Initialise initialise = new Initialise(arg1);
        Assertions.assertEquals(expectedResult, initialise.execute());
    }
}
