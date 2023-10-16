package com.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TaskHelper {
    public List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException e){
            return List.of();
        }
    }

    public String readFileAsString(Path path) {
        StringBuilder content = new StringBuilder();
        for(String line : readFile(path)) {
            content.append(line);
        }
        return content.toString();
    }
}
