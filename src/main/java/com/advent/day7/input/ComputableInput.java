package com.advent.day7.input;

import com.advent.day7.UInt16;

import java.util.Objects;

public class ComputableInput implements Input{

    private UInt16 value;
    private boolean isReady = false;
    private final String name;

    public ComputableInput(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(UInt16 value) {
        this.value = value;
        isReady = true;
    }

    @Override
    public UInt16 getValue() {
        if (!isReady){
            throw new IllegalStateException("Input is not ready yet");
        }
        return value;
    }

    @Override
    public boolean isReady() {
        return isReady;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputableInput that = (ComputableInput) o;

        if (isReady != that.isReady) return false;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (isReady ? 1 : 0);
        return result;
    }
}
