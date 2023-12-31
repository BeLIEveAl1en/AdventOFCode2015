package com.advent.day3;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        String input = taskHelper.readFileAsString(Path.of("src/main/resources/com/advent/day3/task3.txt"));

        System.out.println(countVisitedHouses(input));
    }

    private static int countVisitedHouses(String input) {
        Set<Point> visitedHouses = new HashSet<>();
        Point startingPosition = new Point(0, 0);
        InstructionConverter instructionConverter = new InstructionConverter(startingPosition);
        visitedHouses.add(startingPosition);

        for (char instruction : input.toCharArray()){
            visitedHouses.add(instructionConverter.changePosition(instruction));
        }
        return visitedHouses.size();
    }
}
