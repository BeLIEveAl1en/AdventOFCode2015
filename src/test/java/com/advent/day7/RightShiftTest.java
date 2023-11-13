package com.advent.day7;

import com.advent.day7.input.ComputableInput;
import com.advent.day7.input.ConstantInput;
import com.advent.day7.operator.RightShift;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RightShiftTest {
    @Test
    public void shouldBeReadyWhenAllInputsReady(){
        ConstantInput arg1 = new ConstantInput(12);
        ConstantInput arg2 = new ConstantInput(11);
        RightShift rightShift= new RightShift(arg1, arg2);
        Assertions.assertTrue(rightShift.isReady());
    }

    @Test
    public void shouldBeNotReadyWhenFirstInputIsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        arg2.setValue(new UInt16(12));
        RightShift rightShift= new RightShift(arg1, arg2);
        Assertions.assertFalse(rightShift.isReady());
    }

    @Test
    public void shouldBeNotReadyWhenSecondInputIsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        arg1.setValue(new UInt16(12));
        RightShift rightShift= new RightShift(arg1, arg2);
        Assertions.assertFalse(rightShift.isReady());
    }


    @Test
    public void shouldBeNotReadyWhenAllInputsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        RightShift rightShift= new RightShift(arg1, arg2);
        Assertions.assertFalse(rightShift.isReady());
    }

    @Test
    public void shouldExecute(){
        UInt16 expectedResult = new UInt16(11);
        ConstantInput arg1 = new ConstantInput(45);
        ConstantInput arg2 = new ConstantInput(2);
        RightShift rightShift = new RightShift(arg1, arg2);
        Assertions.assertEquals(expectedResult, rightShift.execute());
    }
}
