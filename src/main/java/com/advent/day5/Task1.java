package com.advent.day5;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        List<String> input = taskHelper.readFile(Path.of("src/main/resources/com/advent/day3/task3.txt"));

        List<Line> lines = new ArrayList<>();
        lines.add(new Line(false, true, true));
        lines.add(new Line(true, true, true));
        lines.add(new Line(true, false, false));
        lines.add(new Line(false, false, true));
        lines.add(new Line(true, true, false));

        Criteria doubleLetter = new DoubleLetterCriteria();

        System.out.println(doubleLetter.meetCriteria(lines).size());
    }

    private static List<Line> addLineToList(List<String> input){
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < input.size() - 1; i++){
            int countOfVowels = 0;
            boolean flag = false;
            boolean doubleLetter = false;
            boolean wrongCombination = false;
            for (int j = 0; j < input.size(); j++){
                if (input.get(i).equals("a") || input.get(i).equals("e") || input.get(i).equals("i") || input.get(i).equals("o") || input.get(i).equals("u"))
                    countOfVowels++;
                if (input.get(i).equals(input.get(i + 1)))
                    doubleLetter = true;
                if (input.get(i).equals("x") && input.get(i).equals("y") || input.get(i).equals("a") && input.get(i).equals("b") || input.get(i).equals("c") && input.get(i).equals("d") || input.get(i).equals("p") && input.get(i).equals("q"))
                    wrongCombination = true;
            }
            if (countOfVowels >= 3)
                flag = true;
            lines.add(new Line(flag, doubleLetter, wrongCombination));
        }
        return lines;
    }
}
