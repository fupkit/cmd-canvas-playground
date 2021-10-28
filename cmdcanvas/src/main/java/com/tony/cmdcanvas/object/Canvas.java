package com.tony.cmdcanvas.object;

import com.tony.cmdcanvas.exception.InvalidInputException;
import lombok.Data;
import lombok.NonNull;

import java.util.stream.IntStream;

import static com.tony.cmdcanvas.Constants.*;

@Data
public class Canvas {
    private static final String EDGE_HORIZONTAL = "-";
    private static final String EDGE_VERTICAL = "|";
    private static final int CANVAS_EDGE = 2;


    private Point[][] content;
    @NonNull
    private int width;
    @NonNull
    private int height;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.initializeContent(this.height, this.width);
    }

    public String drawContent() {
        StringBuilder sb = new StringBuilder();
        int heightWithEdge = height + CANVAS_EDGE;
        int widthWithEdge = width + CANVAS_EDGE;
        int lastHeightIndex = heightWithEdge - 1;
        int lastWidthIndex = widthWithEdge - 1;
        for (int y = 0; y < heightWithEdge; y++) {
            for (int x = 0; x < widthWithEdge; x++) {
                if (y == 0 || y == lastHeightIndex) {
                    sb.append(EDGE_HORIZONTAL);
                } else if (x == 0 || x == lastWidthIndex) {
                    sb.append(EDGE_VERTICAL);
                } else {
                    sb.append(content[y - 1][x - 1]);
                }
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void checkCoordinate(int x, int y, String input) throws InvalidInputException {
        if (x > width || y > height) {
            throw new InvalidInputException(String.format(CANVAS_OUT_OF_BOUND, input, width, height));
        }
    }

    private void initializeContent(int height, int width) {
        this.content = new Point[height][width];
        IntStream.range(0, width).forEach(x -> IntStream.range(0, height).forEach(y -> this.content[y][x] = new Point(x, y, EMPTY)));
    }
}
