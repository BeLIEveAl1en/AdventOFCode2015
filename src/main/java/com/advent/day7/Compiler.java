package com.advent.day7;

import java.util.List;

interface Compiler {
    void compile(List<String> commands);

    UInt16 getValue(String variableName);
}
