package com.advent.day3;

public class InstructionConverter {
    private Point currentPoint;

    public InstructionConverter(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public Point changePosition(char instruction) {
         switch (instruction) {
             case '^':
                 return updateCurrentPoint(new Point(currentPoint.getX(), currentPoint.getY() + 1));

             case 'v':
                 return updateCurrentPoint(new Point(currentPoint.getX(), currentPoint.getY() - 1));

             case '>':
                 return updateCurrentPoint(new Point(currentPoint.getX() + 1, currentPoint.getY()));

             case '<':
                 return updateCurrentPoint(new Point(currentPoint.getX() - 1, currentPoint.getY()));

             default:
                 throw new IllegalArgumentException("Unknown instruction: " + instruction);
         }
    }

    private Point updateCurrentPoint(Point point){
        currentPoint = point;
        return currentPoint;
    }


}
