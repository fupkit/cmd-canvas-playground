package com.tony.cmdcanvas.command;

import com.tony.cmdcanvas.exception.InvalidInputException;
import com.tony.cmdcanvas.object.Canvas;
import lombok.Getter;

@Getter
public class BucketFillCommand extends AbstractDrawCommand{
    private static final String PATTERN = "^B ([0-9]+) ([0-9]+) [A-Za-z]$";
    private int x;
    private int y;
    private String color;

    public BucketFillCommand(String input) throws InvalidInputException {
        super(input);
    }

    @Override
    String getPattern() {
        return PATTERN;
    }

    @Override
    void parseCommand(String input) {
        String[] inputs = splitBySpace(input);
        this.x = mapToArrayIndex(inputs[1]);
        this.y = mapToArrayIndex(inputs[2]);
        this.color = inputs[3];
    }

    @Override
    public void draw(Canvas canvas) throws InvalidInputException {
        checkCoordinate(x, y, canvas);
        canvas.getContent()[y][x].bucketFill(canvas, color);
    }
}
