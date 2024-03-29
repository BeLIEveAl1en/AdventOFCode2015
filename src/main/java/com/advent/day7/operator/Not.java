package com.advent.day7.operator;

import com.advent.day7.UInt16;
import com.advent.day7.input.Input;

import java.util.List;

public class Not implements Operator{

    private final Input argument1;

    public Not(Input argument1) {
        this.argument1 = argument1;
    }

    @Override
    public boolean isReady() {
        return argument1.isReady();
    }

    @Override
    public UInt16 execute() {
        return argument1.getValue().not();
    }

    @Override
    public List<Input> getAllInputs() {
        return List.of(argument1);
    }
}
