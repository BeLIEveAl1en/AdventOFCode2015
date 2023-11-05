package com.advent.day7;

import java.math.BigInteger;
import java.util.BitSet;

public class UInt16 {

    private static final int MIN = 0;
    private static final int MAX = 65535;
    private static final int BITS_NUMBER = 16;

    private final BitSet value;

    public UInt16(int value) {
        if (value > MAX || value < MIN){
            throw new IllegalArgumentException("Illegal value = " + value + ". Max = " + MAX + ", Min = " + MIN);
        }
        this.value = new BitSet(BITS_NUMBER);
        this.value.clear();
        BigInteger bigIntValue = BigInteger.valueOf(value);
        for (int i = 0; i < BITS_NUMBER; i++){
            this.value.set(i, bigIntValue.testBit(i));
        }
    }

    public int getValue() {
        return toInt(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UInt16 uInt16 = (UInt16) o;

        return value.equals(uInt16.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public UInt16 and(UInt16 other){
        BitSet resultBitSet = (BitSet) value.clone();
        resultBitSet.and(other.value);
        return new UInt16(toInt(resultBitSet));
    }

    private static int toInt(BitSet value){
        if (value.length() == 0){
            return 0;
        }
        return new BigInteger(value.toByteArray()).intValue();
    }
}
