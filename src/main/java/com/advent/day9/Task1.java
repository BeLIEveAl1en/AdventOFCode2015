package com.advent.day9;

import com.advent.TaskHelper;
import com.advent.day9.input.Route;
import com.advent.day9.input.RouteReader;

import java.nio.file.Path;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        List<String> input = taskHelper.readFile(Path.of("src/main/resources/com/advent/day9/task1.txt"));
        RouteReader routeReader = new RouteReader();
        List<Route> routes = routeReader.read(input);


    }
}
