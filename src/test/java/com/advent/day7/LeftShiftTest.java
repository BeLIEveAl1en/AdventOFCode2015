package com.advent.day7;

import com.advent.day7.input.ComputableInput;
import com.advent.day7.input.ConstantInput;
import com.advent.day7.operator.LeftShift;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeftShiftTest {
    @Test
    public void shouldBeReadyWhenAllInputsReady(){
        ConstantInput arg1 = new ConstantInput(12);
        ConstantInput arg2 = new ConstantInput(11);
        LeftShift leftShift= new LeftShift(arg1, arg2);
        Assertions.assertTrue(leftShift.isReady());
    }

    @Test
    public void shouldBeNotReadyWhenFirstInputIsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        arg2.setValue(new UInt16(12));
        LeftShift leftShift= new LeftShift(arg1, arg2);
        Assertions.assertFalse(leftShift.isReady());
    }

    @Test
    public void shouldBeNotReadyWhenSecondInputIsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        arg1.setValue(new UInt16(12));
        LeftShift leftShift= new LeftShift(arg1, arg2);
        Assertions.assertFalse(leftShift.isReady());
    }


    @Test
    public void shouldBeNotReadyWhenAllInputsNotReady(){
        ComputableInput arg1 = new ComputableInput("x");
        ComputableInput arg2 = new ComputableInput("y");
        LeftShift leftShift= new LeftShift(arg1, arg2);
        Assertions.assertFalse(leftShift.isReady());
    }

    @Test
    public void shouldExecute(){
        UInt16 expectedResult = new UInt16(180);
        ConstantInput arg1 = new ConstantInput(45);
        ConstantInput arg2 = new ConstantInput(2);
        LeftShift leftShift = new LeftShift(arg1, arg2);
        Assertions.assertEquals(expectedResult, leftShift.execute());
    }
}
