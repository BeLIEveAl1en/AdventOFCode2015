package com.advent.day3;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Task2 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        String input = taskHelper.readFileAsString(Path.of("src/main/resources/com/advent/day3/task3.txt"));

        System.out.println(countVisitedHouses(input));
    }

    private static int countVisitedHouses(String input) {
        Set<Point> visitedHouses = new HashSet<>();
        Point startingPosition = new Point(0, 0);
        InstructionConverter instructionConverterSanta = new InstructionConverter(startingPosition);
        InstructionConverter instructionConverterRobotSanta = new InstructionConverter(startingPosition);
        visitedHouses.add(startingPosition);

        for (int i = 0; i < input.length(); i++){
            InstructionConverter currentConverter = (i % 2 == 0) ? instructionConverterSanta : instructionConverterRobotSanta;
            visitedHouses.add(currentConverter.changePosition(input.charAt(i)));
        }
        return visitedHouses.size();
    }
}
