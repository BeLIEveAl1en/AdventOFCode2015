package com.advent.day5;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        List<String> input = taskHelper.readFile(Path.of("src/main/resources/com/advent/day5/task5.txt"));

        Criteria<String> repetitiveLetters = new RepetitiveLettersCriteria();
        Criteria<String> repetitivePairs = new RepetitivePairsCriteria();

        System.out.println(new AndCriteria<>(repetitiveLetters, repetitivePairs).meetCriteria(input).size());
    }
}
