package com.advent.day7;

import com.advent.day7.input.ComputableInput;
import com.advent.day7.input.ConstantInput;
import com.advent.day7.operator.Not;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotTest {
    @Test
    public void shouldBeReadyWhenInputsReady(){
        ConstantInput arg1 = new ConstantInput(12);
        Not not = new Not(arg1);
        Assertions.assertTrue(not.isReady());
    }

    @Test
    public void shouldBeNotReadyWhenInputsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        Not not = new Not(arg1);
        Assertions.assertFalse(not.isReady());
    }

    @Test
    public void shouldExecute(){
        UInt16 expectedResult = new UInt16(65412);
        ConstantInput arg1 = new ConstantInput(123);
        Not not = new Not(arg1);
        Assertions.assertEquals(expectedResult, not.execute());
    }
}
