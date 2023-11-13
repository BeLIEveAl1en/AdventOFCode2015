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
            boolean bitValue = bigIntValue.testBit(i);
            this.value.set(i, bitValue);
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

    public UInt16 or(UInt16 other){
        BitSet resultBitSet = (BitSet) value.clone();
        resultBitSet.or(other.value);
        return new UInt16(toInt(resultBitSet));
    }

    public UInt16 not(){
        BitSet resultBitSet = (BitSet) value.clone();
        resultBitSet.flip(0, BITS_NUMBER);
        return new UInt16(toInt(resultBitSet));
    }

    public UInt16 leftShift(UInt16 shift){
        BitSet resultBitSet = new BitSet(BITS_NUMBER);
        int intShift = shift.getValue();
        if (intShift >= BITS_NUMBER){
            return new UInt16(0);
        }
        for (int i = intShift; i < BITS_NUMBER; i++) {
            resultBitSet.set(i, this.value.get(i - intShift));
        }
        return new UInt16(toInt(resultBitSet));
    }

    public UInt16 rightShift(UInt16 shift){
        BitSet resultBitSet = new BitSet(BITS_NUMBER);
        int intShift = shift.getValue();
        if (intShift >= BITS_NUMBER){
            return new UInt16(0);
        }
        for (int i = 0; i < BITS_NUMBER - intShift; i++) {
            resultBitSet.set(i, this.value.get(i + intShift));
        }
        return new UInt16(toInt(resultBitSet));
    }

    private static int toInt(BitSet value){
        int intValue = 0;
        for (int i = value.nextSetBit(0); i >= 0; i = value.nextSetBit(i+1)) {
            intValue += (1 << i);
        }
        return intValue;
    }

    @Override
    public String toString() {
        return "UInt16{" +
                "value=" + toInt(value) +
                '}';
    }
}
