package com.advent.day7.operator;

import com.advent.day7.UInt16;

public interface Operator {

    boolean isReady();

    UInt16 execute();
}
