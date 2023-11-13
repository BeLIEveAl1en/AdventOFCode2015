package com.advent.day7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UInt16Test {
    @ParameterizedTest
    @CsvSource({
                "256",
                "389",
                "1015",
                "2001",
                "34543",
                "50781",
                "62900",
                "65534",})
    public void shouldCreateFromInt(int intValue){
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

    @ParameterizedTest
    @CsvSource({"1,0,1",
            "1,1,1",
            "0,1,1",
            "0,0,0"})
    public void shouldExecuteOr(int arg1, int arg2, int expectedResult){
        UInt16 result = new UInt16(arg1).or(new UInt16(arg2));
        Assertions.assertEquals(expectedResult, result.getValue());
    }

    @ParameterizedTest
    @CsvSource({"1,65534",
                "0,65535",})
    public void shouldExecuteNot(int arg1, int expectedResult){
        UInt16 result = new UInt16(arg1).not();
        Assertions.assertEquals(expectedResult, result.getValue());
    }

    @ParameterizedTest
    @CsvSource({"1,0,1",
                "1,1,2",
                "0,1,0",
                "1,4,16",
                "1,20,0"})
    public void shouldExecuteLeftShift(int arg1, int arg2, int expectedResult){
        UInt16 result = new UInt16(arg1).leftShift(new UInt16(arg2));
        Assertions.assertEquals(expectedResult, result.getValue());
    }

    @ParameterizedTest // 0000000000000001
    @CsvSource({"1,0,1",
                "2,1,1",
                "0,1,0",
                "1,4,0",
                "1,20,0"})
    public void shouldExecuteRightShift(int arg1, int arg2, int expectedResult){
        UInt16 result = new UInt16(arg1).rightShift(new UInt16(arg2));
        Assertions.assertEquals(expectedResult, result.getValue());
    }
}
