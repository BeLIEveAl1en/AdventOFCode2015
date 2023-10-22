package com.advent.day2;

import com.advent.TaskHelper;

import java.nio.file.Path;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        TaskHelper taskHelper = new TaskHelper();
        List<String> sizes = taskHelper.readFile(Path.of("src/main/resources/com/advent/day2/task2input.txt"));
        System.out.println(countOfMaterial(sizes));
    }

    private static int[] findSizes(String size) {
        StringBuilder l = new StringBuilder();
        StringBuilder w = new StringBuilder();
        StringBuilder h = new StringBuilder();

        int state = 0;

        for (int i = 0; i < size.length(); i++) {
            switch (state) {
                case 0:
                    if (size.charAt(i) == 'x') {
                        state++;
                    }
                    else {
                        l.append(size.charAt(i));
                    }
                    break;
                case 1:
                    if (size.charAt(i) == 'x') {
                        state++;
                    }
                    else {
                        w.append(size.charAt(i));
                    }
                    break;
                case 2:
                    if (size.charAt(i) == 'x') {
                        state++;
                    }
                    else {
                        h.append(size.charAt(i));
                    }
                    break;
            }
        }
        return new int[]{Integer.parseInt(l.toString()), Integer.parseInt(w.toString()), Integer.parseInt(h.toString())};
    }

    private static int countOfMaterial(List<String> sizes) {
        int l;
        int w;
        int h;
        int count = 0;
        int[] size;

        for (String s : sizes) {
            size = findSizes(s);
            l = size[0];
            w = size[1];
            h = size[2];
            count += 2 * l * w + 2 * w * h + 2 * h * l;
            if (l * w <= w * h && l * w <= h * l)
                count += l * w;
            else if (w * h <= l * w && w * h <= h * l)
                count += w * h;
            else if (h * l <= l * w && h * l <= w * h)
                count += l * h;
        }
        return count;
    }
}
