package com.advent.day6;

public class GridOfLamps {
    private final Lamp[][] grid;

    public GridOfLamps(int width, int height) {
        grid = new Lamp[width][height];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                grid[i][j] = new Lamp(0);
            }
        }
    }

    public void turnOnForRange(int x1, int y1, int x2, int y2){
        for (int i = 0; i < x2-x1 + 1; i++){
            for (int j = 0; j < y2-y1 + 1; j++){
                grid[x1 + i][y1 + j].turnOn();
            }
        }
    }

    public void turnOffForRange(int x1, int y1, int x2, int y2){
        for (int i = 0; i < x2-x1 + 1; i++){
            for (int j = 0; j < y2-y1 + 1; j++){
                grid[x1 + i][y1 + j].turnOff();
            }
        }
    }

    public void toggleForRange(int x1, int y1, int x2, int y2){
        for (int i = 0; i < x2-x1 + 1; i++){
            for (int j = 0; j < y2-y1 + 1; j++){
                grid[x1 + i][y1 + j].toggle();
            }
        }
    }

    public int countLamps(){
        int counter = 0;
        for (Lamp[] lamps : grid) {
            for (Lamp lamp : lamps) {
                counter += lamp.getState();
            }
        }
        return counter;
    }
}
