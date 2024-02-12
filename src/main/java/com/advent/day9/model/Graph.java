package com.advent.day9.model;

import com.advent.day9.input.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<String, City> cities = new HashMap();

    public Graph(List<Route> routes) {
        for (Route route : routes){
            City from = cities.computeIfAbsent(route.from(), City::new);
            City to = cities.computeIfAbsent(route.to(), City::new);
            from.addConnection(to.getName(), route.distance());
            to.addConnection(from.getName(), route.distance());
        }
    }

    private Path getShortestFullTravelRoute(){
        return null;
    }

    private static class Path{
        private int totalDistance = 0;
        private final List<String> cities = new ArrayList<>();

        public Path(String firstCityName){
            cities.add(firstCityName);
        }

        public void addCity(String name, int distance){
            cities.add(name);
            totalDistance += distance;
        }
    }
}

