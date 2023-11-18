package com.advent.day6;

import java.util.List;

public class ProcessRequest {
    public int[] findCoordinates(String input){
        int[] numbers = new int[4];
        String[] parts = input.split("[^0-9]+");
        for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(parts[i + 1]);
        }
        return numbers;
    }

    public String findCommandInRequest(String input){
        StringBuilder command = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                command.append(input.charAt(i));
            }
            else {
                break;
            }
        }
        return command.toString();
    }

    public void processRequest(GridOfLamps grid, String input){
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

    public void processListOfRequest(GridOfLamps grid, List<String> listOfRequest){
        for (String req : listOfRequest){
            processRequest(grid, req);
        }
    }
}
