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
    public void shouldCountLampsWithTurnOnCommand1(){
        int expected = 4;
        GridOfLamps grid = new GridOfLamps(10, 10);
        grid.turnOnForRange(1, 1, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithTurnOnCommand2(){
        int expected = 9;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.turnOnForRange(0, 0, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithTurnOnCommand3(){
        int expected = 6;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.turnOnForRange(1, 0, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithTurnOffCommand1(){
        int expected = 0;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.turnOnForRange(0, 0, 3, 3);
        grid.turnOffForRange(0, 0, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithTurnOffCommand2(){
        int expected = 0;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.turnOnForRange(0, 1, 3, 3);
        grid.turnOffForRange(0, 0, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithToggleCommand1(){
        int expected = 3;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.turnOnForRange(1, 0, 3, 3);
        grid.toggleForRange(0,0, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }

    @Test
    public void shouldCountLampsWithToggleCommand2(){
        int expected = 9;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.toggleForRange(0,0, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }


    @Test
    public void shouldCountLampsWithToggleCommand3(){
        int expected = 0;
        GridOfLamps grid = new GridOfLamps(3, 3);
        grid.turnOnForRange(1, 1, 3, 3);
        grid.toggleForRange(1,1, 3, 3);
        Assertions.assertEquals(expected, grid.countLamps());
    }
}
