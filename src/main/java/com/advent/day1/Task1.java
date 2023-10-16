package com.advent.day1;

import com.advent.TaskHelper;

import java.nio.file.Path;

public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        String input = taskHelper.readFileAsString(Path.of("src/main/resources/com/advent/day1/task1input.txt"));

        System.out.println(countFloors(input));
    }

    private static int countFloors(String instructions){
        int counter = 0;
        for (int i = 0; i < instructions.length(); i++){
            if (instructions.charAt(i) == '('){
                counter++;
            }
            else {
                counter--;
            }
        }
        return counter;
    }
}
