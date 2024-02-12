package com.advent.day9.input;

import java.util.List;
import java.util.regex.Pattern;

public class RouteReader {
    private static final Pattern ROUTE_PATTERN = Pattern.compile("(\\w+)\\s+to\\s+(\\w+)\\s+=\\s+(\\d+)");

    public Route read(String input){
        var matcher = ROUTE_PATTERN.matcher(input);
        if (!matcher.matches()){
            throw new IllegalArgumentException("Input not matches with pattern");
        }
        return new Route(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));
    }

    public List<Route> read(List<String> input){
        return input.stream()
                .map(this::read)
                .toList();
    }
}
