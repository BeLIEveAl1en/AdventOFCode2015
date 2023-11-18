package com.advent.day6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridOfLampTest {
    @Test
    public void shouldCountLampsWithNoCommands(){
        int expected = 0;
        GridOfLamps grid = new GridOfLamps(10, 10);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithTurnOnCommand(){
        int expected = 9;
        GridOfLamps grid = new GridOfLamps(10, 10);
        grid.turnOnForRange(1, 1, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithTurnOffCommand(){
        int expected = 0;
        GridOfLamps grid = new GridOfLamps(4, 4);
        grid.turnOnForRange(0, 0, 3, 3);
        grid.turnOffForRange(0, 0, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithToggleCommand(){
        int expected = 9;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.toggleForRange(0,0, 2, 2);
        Assertions.assertEquals(expected, grid.countLamps());
    }
}
