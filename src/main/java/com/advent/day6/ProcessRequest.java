package com.advent.day6;

import java.util.Objects;

public class ProcessRequest {
    public int[] findCoordinates(String input){
        int[] numbers = new int[4];
        String[] parts = input.split("[^0-9]+");
        for (int i = 0; i < 4; i++) {
            if (!Objects.equals(parts[i], "")){
                numbers[i] = Integer.parseInt(parts[i]);
            }
        }
        return numbers;
    }

    public String findCommandInRequest(String input){
        StringBuilder command = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            if (!Character.isDigit(input.charAt(i))){
                command.append(input.charAt(i));
            }
        }
        return command.toString();
    }
}
