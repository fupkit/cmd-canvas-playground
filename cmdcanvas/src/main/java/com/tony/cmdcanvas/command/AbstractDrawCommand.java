package com.tony.cmdcanvas.command;

import com.tony.cmdcanvas.exception.InvalidInputException;
import com.tony.cmdcanvas.object.*;

import static com.tony.cmdcanvas.Constants.*;

public abstract class AbstractDrawCommand extends AbstractCommand {
    public AbstractDrawCommand(String input) throws InvalidInputException {
        super(input);
    }

    public abstract void draw(Canvas canvas) throws InvalidInputException;

    protected void checkCoordinate(int x, int y, Canvas canvas) throws InvalidInputException {
        canvas.checkCoordinate(x, y, input);
    }

    protected void drawVertical(Canvas canvas, int x, int y1, int y2) {
        Point[][] content = canvas.getContent();
        int larger = Math.max(y1, y2);
        int smaller = larger == y1 ? y2 : y1;
        for (int i = smaller; i <= larger; i++) {
            content[i][x].setValue(X);
        }
    }

    protected void drawHorizontal(Canvas canvas, int y, int x1, int x2) {
        Point[][] content = canvas.getContent();
        int larger = Math.max(x1, x2);
        int smaller = larger == x1 ? x2 : x1;
        for (int i = smaller; i <= larger; i++) {
            content[y][i].setValue(X);
        }
    }

    protected int mapToArrayIndex(String str) {
        return Integer.parseInt(str) - 1; // map to index of array
    }
}
