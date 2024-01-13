package com.advent.day7;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        List<String> input = taskHelper.readFile(Path.of("src/main/resources/com/advent/day7/input.txt"));
        Compiler compiler = new CompilerImpl();
        compiler.compile(input);
        System.out.println(compiler.getValue("a"));
    }
}
