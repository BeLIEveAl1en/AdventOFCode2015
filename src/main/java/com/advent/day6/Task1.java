package com.advent.day6;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        List<String> input = taskHelper.readFile(Path.of("src/main/resources/com/advent/day6/test1.txt"));
        GridOfLamps grid = new GridOfLamps(1000, 1000);

        for (String req : input){
            processRequest(grid, req);
        }
        System.out.println(grid.countLamps());
    }

    public static void processRequest(GridOfLamps grid, String input){
        ProcessRequest processRequest = new ProcessRequest();
        int[] nums = processRequest.findCoordinates(input);
        String command = processRequest.findCommandInRequest(input);

        switch (command){
            case "turn on ":
                grid.turnOnForRange(nums[0], nums[1], nums[2], nums[3]);
                break;

            case "turn off ":
                grid.turnOffForRange(nums[0], nums[1], nums[2], nums[3]);
                break;

            case "toggle ":
                grid.toggleForRange(nums[0], nums[1], nums[2], nums[3]);
                break;
        }
    }
}
