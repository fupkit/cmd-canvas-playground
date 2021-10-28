package com.tony.cmdcanvas.command;

import com.tony.cmdcanvas.exception.InvalidInputException;
import com.tony.cmdcanvas.object.Canvas;

public class CanvasCommand extends AbstractCommand{
    private static final String PATTERN = "^C ([0-9]+) ([0-9]+)$";
    private int width;
    private int height;

    public CanvasCommand(String input) throws InvalidInputException {
        super(input);
    }

    @Override
    String getPattern() {
        return PATTERN;
    }

    @Override
    void parseCommand(String input) {
        String[] inputs = splitBySpace(input);
        this.width = Integer.parseInt(inputs[1]);
        this.height = Integer.parseInt(inputs[2]);
    }

    public Canvas execute() {
        return new Canvas(this.width, this.height);
    }
}
