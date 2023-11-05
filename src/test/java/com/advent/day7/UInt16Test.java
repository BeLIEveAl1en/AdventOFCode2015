package com.advent.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UInt16Test {
    @Test
    public void shouldCreateFromInt(){
        int intValue = 54;
        UInt16 uIntValue = new UInt16(intValue);
        Assertions.assertEquals(intValue, uIntValue.getValue());
    }

    @Test
    public void shouldThrowWhenInputNegative(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UInt16(-9));
    }

    @Test
    public void shouldThrowWhenInputBigger16Bit(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UInt16(1_000_000));
    }

    @ParameterizedTest
    @CsvSource({"1,0,0",
                "1,1,1",
                "0,1,0",
                "0,0,0"})
    public void shouldExecuteAnd(int arg1, int arg2, int expectedResult){
        UInt16 result = new UInt16(arg1).and(new UInt16(arg2));
        Assertions.assertEquals(expectedResult, result.getValue());
    }


}
