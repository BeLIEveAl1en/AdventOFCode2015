package com.advent.day7.operator;

import com.advent.day7.UInt16;
import com.advent.day7.input.Input;

import java.util.List;

public class LeftShift implements Operator{

    private final Input argument1;
    private final Input shift;

    public LeftShift(Input argument1, Input shift) {
        this.argument1 = argument1;
        this.shift = shift;
    }

    @Override
    public boolean isReady() {
        return argument1.isReady() && shift.isReady();
    }

    @Override
    public UInt16 execute() {
        return argument1.getValue().leftShift(shift.getValue());
    }

    @Override
    public List<Input> getAllInputs() {
        return List.of(argument1, shift);
    }
}
