package com.tony.cmdcanvas;

public class Constants {
    public static final String INVALID_INPUT_MSG = "Invalid Input! : [%s], %s";
    public static final String ELIGIBLE_INPUT_DESC = "eligible inputs are: \n Command \t\tDescription\n" +
            "C w h           Create a new canvas of width w and height h.\n" +
            "L x1 y1 x2 y2   Create a new line from (x1,y1) to (x2,y2). Currently only\n" +
            "                horizontal or vertical lines are supported. Horizontal and vertical lines\n" +
            "                will be drawn using the 'x' character.\n" +
            "R x1 y1 x2 y2   Create a new rectangle, whose upper left corner is (x1,y1) and\n" +
            "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" +
            "                using the 'x' character.\n" +
            "B x y c         Fill the entire area connected to (x,y) with \"colour\" c. The\n" +
            "                behaviour of this is the same as that of the \"bucket fill\" tool in paint\n" +
            "                programs.\n" +
            "Q               Quit the program.";
    public static final String LINE_INPUT_DESC = "Currently only horizontal or vertical lines are supported.";
    public static final String CANVAS_OUT_OF_BOUND = "Input coordinate out of bound! Input: [%s], canvas size: %d x %d";
    public static final String ERROR_MSG_CANVAS_NOT_EXIST = "Canvas not yet created! Please create a canvas via command : \nC w h           Create a new canvas of width w and height h.";
    public static final String EMPTY = " ";
    public static final String X = "X";
}
