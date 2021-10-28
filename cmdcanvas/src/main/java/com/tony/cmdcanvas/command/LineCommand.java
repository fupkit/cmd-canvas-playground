package com.tony.cmdcanvas.command;

import com.tony.cmdcanvas.exception.InvalidInputException;
import com.tony.cmdcanvas.object.*;

import static com.tony.cmdcanvas.Constants.*;

public class LineCommand extends AbstractDrawCommand {
    private static final String PATTERN = "^L ([0-9]+) ([0-9]+) ([0-9]+) ([0-9]+)$";
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public LineCommand(String input) throws InvalidInputException {
        super(input);
    }

    @Override
    String getPattern() {
        return PATTERN;
    }

    @Override
    void parseCommand(String input) {
        String[] inputs = splitBySpace(input);
        this.x1 = mapToArrayIndex(inputs[1]);
        this.y1 = mapToArrayIndex(inputs[2]);
        this.x2 = mapToArrayIndex(inputs[3]);
        this.y2 = mapToArrayIndex(inputs[4]);
    }


    @Override
    public void draw(Canvas canvas) throws InvalidInputException {
        if (x1 != x2 && y1 != y2) {
            throwInvalidLineInput();
        }
        checkCoordinate(x1, y1, canvas);
        checkCoordinate(x2, y2, canvas);
        if (x1 == x2) {
            drawVertical(canvas,x1, y1, y2);
        } else {
            drawHorizontal(canvas, y1, x1, x2);
        }
    }




    private void throwInvalidLineInput() throws InvalidInputException {
        throw new InvalidInputException(String.format(INVALID_INPUT_MSG, this.input, LINE_INPUT_DESC));
    }
}
