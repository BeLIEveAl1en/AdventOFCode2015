package com.advent.day6;

public class UnlimitedBrightnessLamp extends Lamp{

    public UnlimitedBrightnessLamp(int state) {
        super(state);
    }

    @Override
    public void turnOn() {
        setState(getState() + 1);
    }

    @Override
    public void turnOff() {
        setState(Math.max(getState() - 1, 0));
    }

    @Override
    public void toggle() {
        setState(getState() + 2);
    }
}
