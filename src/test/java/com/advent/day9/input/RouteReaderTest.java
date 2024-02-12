package com.advent.day9.input;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RouteReaderTest {
    private final RouteReader routeReader = new RouteReader();

    @Test
    public void shouldReadString() {
        String input = "Tristram to AlphaCentauri = 34";
        Route routeResult = new Route("Tristram", "AlphaCentauri", 34);
        Assertions.assertEquals(routeResult, routeReader.read(input));
    }

    @Test
    public void shouldThrow() {
        String input = "Tristram tow AlphaCentauri = 34";
        Assertions.assertThrows(IllegalArgumentException.class, () -> routeReader.read(input));
    }

    @Test
    public void shouldReadManyStrings() {
        List<String> input = List.of("Tristram to AlphaCentauri = 34", "Snowdin to Tambi = 105");
        List<Route> expected = List.of(new Route("Tristram", "AlphaCentauri", 34),
                new Route("Snowdin", "Tambi", 105));
        Assertions.assertEquals(expected, routeReader.read(input));
    }
}
