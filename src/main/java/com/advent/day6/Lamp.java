package com.advent.day6;

public class Lamp {
    private int state;

    public Lamp(int state) {
        this.state = state;
    }

    public void turnOn(){
        state = 1;
    }

    public void turnOff(){
        state = 0;
    }

    public void toggle(){
        if (state == 0){
            state = 1;
        }
        else {
            state = 0;
        }
    }

    public int getState() {
        return state;
    }

    protected void setState(int state) {
        this.state = state;
    }
}
