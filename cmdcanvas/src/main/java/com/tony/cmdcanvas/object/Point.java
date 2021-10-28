package com.tony.cmdcanvas.object;

import lombok.*;

import java.util.*;

import static com.tony.cmdcanvas.Constants.*;

@Getter
@Setter
@AllArgsConstructor
public class Point {
    private int x;
    private int y;
    private String value;

    public void bucketFill(Canvas canvas, String color) {
        if (notFilled(color)) {
            this.value = color;
            Point[][] content = canvas.getContent();

            List<Point> neighbors = new ArrayList<>();

            boolean yPlus1Inbound = (y + 1 >= 0) && (y + 1 < content.length);
            boolean yMinus1Inbound = (y - 1 >= 0) && (y - 1 < content.length);
            if (yPlus1Inbound) {
                addYAxisNeighbor(y + 1, content, neighbors);
            }

            if (yMinus1Inbound) {
                addYAxisNeighbor(y - 1, content, neighbors);
            }
            addYAxisNeighbor(y, content, neighbors);
            //recursive call until non-empty value
            neighbors.forEach(p -> p.bucketFill(canvas, color));
        }

    }

    private boolean notFilled(String color) {
        return this.value == null || !X.equals(this.value) && !this.value.equals(color);
    }

    private void addYAxisNeighbor(int yAxis, Point[][] content, List<Point> neighbors) {
        boolean xPlus1Inbound = (x + 1 >= 0) && (x + 1 < content[yAxis].length);
        boolean xMinus1Inbound = (x - 1 >= 0) && (x - 1 < content[yAxis].length);
        if (xPlus1Inbound) {
            neighbors.add(content[yAxis][x + 1]);
        }
        if (xMinus1Inbound) {
            neighbors.add(content[yAxis][x - 1]);
        }
        if(!this.equals(content[yAxis][x])) {
            neighbors.add(content[yAxis][x]);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point) {
            Point p = (Point) obj;
            return this.x == p.getX() && this.y == p.getY();
        }
        return false;
    }
}
