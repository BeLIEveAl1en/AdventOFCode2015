package com.advent.day7.operator;

import com.advent.day7.UInt16;
import com.advent.day7.input.Input;

import java.util.List;

public interface Operator {

    boolean isReady();

    UInt16 execute();

    List<Input> getAllInputs();
}
