package com.advent.day6;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.List;


public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        List<String> input = taskHelper.readFile(Path.of("src/main/resources/com/advent/day6/test1.txt"));
        ProcessRequest processRequest = new ProcessRequest();
        GridOfLamps grid = new GridOfLamps(1000, 1000);

        processRequest.processListOfRequest(grid, input);
        System.out.println(grid.countLamps());
        System.out.println(input);
    }
}
