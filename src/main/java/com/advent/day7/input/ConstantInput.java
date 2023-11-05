package com.advent.day7.input;

import com.advent.day7.UInt16;

public class ConstantInput implements Input{
    private final UInt16 value;

    public ConstantInput(int value) {
        this.value = new UInt16(value);
    }

    @Override
    public UInt16 getValue() {
        return value;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConstantInput that = (ConstantInput) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
