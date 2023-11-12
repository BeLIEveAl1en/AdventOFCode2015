package com.advent.day7;

import com.advent.day7.input.ComputableInput;
import com.advent.day7.input.ConstantInput;
import com.advent.day7.operator.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrTest {
    @Test
    public void shouldBeReadyWhenAllInputsReady(){
        ConstantInput arg1 = new ConstantInput(12);
        ConstantInput arg2 = new ConstantInput(11);
        Or or = new Or(arg1, arg2);
        Assertions.assertTrue(or.isReady());
    }

    @Test
    public void shouldBeNotReadyWhenFirstInputIsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        arg2.setValue(new UInt16(12));
        Or or = new Or(arg1, arg2);
        Assertions.assertFalse(or.isReady());
    }

    @Test
    public void shouldBeNotReadyWhenSecondInputIsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        arg1.setValue(new UInt16(12));
        Or or = new Or(arg1, arg2);
        Assertions.assertFalse(or.isReady());
    }


    @Test
    public void shouldBeNotReadyWhenAllInputsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        Or or = new Or(arg1, arg2);
        Assertions.assertFalse(or.isReady());
    }

    @Test
    public void shouldExecute(){
        UInt16 expectedResult = new UInt16(3);
        ConstantInput arg1 = new ConstantInput(2);
        ConstantInput arg2 = new ConstantInput(3);
        Or or = new Or(arg1, arg2);
        Assertions.assertEquals(expectedResult, or.execute());
    }
}
