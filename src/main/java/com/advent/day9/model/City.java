package com.advent.day9.model;

import java.util.HashMap;
import java.util.Map;

public class City {
    private final String name;
    private Map<String, Integer> connections = new HashMap<>();

    public City(String name) {
        this.name = name;
    }

    public Map<String, Integer> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
    }

    public void addConnection(String cityName, int distance){
        connections.put(cityName, distance);
    }
}
