package com.advent.day7.operator;

import com.advent.day7.UInt16;
import com.advent.day7.input.Input;

import java.util.List;

public class Or implements Operator{

    private final Input argument1;
    private final Input argument2;

    public Or(Input argument1, Input argument2) {
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    @Override
    public boolean isReady() {
        return argument1.isReady() && argument2.isReady();
    }

    @Override
    public UInt16 execute() {
        return argument1.getValue().or(argument2.getValue());
    }

    @Override
    public List<Input> getAllInputs() {
        return List.of(argument1, argument2);
    }
}
