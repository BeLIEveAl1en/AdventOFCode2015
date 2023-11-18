package com.advent.day6;

public class Lamp {
    private int state;

    public Lamp(int state) {
        this.state = state;
    }

    public void turnOn(){
        state++;
    }

    public void turnOff(){
        state--;
    }

    public void toggle(){
        state += 2;
    }

    public int getState() {
        return state;
    }
}
