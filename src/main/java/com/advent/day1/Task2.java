package com.advent.day1;

import com.advent.TaskHelper;

import java.nio.file.Path;

public class Task2 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        String input = taskHelper.readFileAsString(Path.of("src/main/resources/com/advent/day1/task1input.txt"));

        System.out.println(findFirstInstructionToCellar(input));
    }

    private static int findFirstInstructionToCellar(String instructions){
        int floor = 0;
        for (int instructionIdx = 0; instructionIdx < instructions.length(); instructionIdx++){
            if (instructions.charAt(instructionIdx) == '('){
                floor++;
            }
            else {
                floor--;
            }
            if (floor == -1){
                return instructionIdx + 1;
            }
        }
        return -1;
    }
}
