package com.cs.consoledrawing.model;

public class CanvasRenderer {

    private static final char HORIZONTAL_EDGE_CHAR = '-';
    private static final char VERTICAL_EDGE_CHAR   = '|';

    public static void render(Canvas canvas){
        int height = canvas.getHeight();
        int width = canvas.getWidth();

        for (int row = 0; row <= height + 1; row++){
            StringBuilder toPrint = new StringBuilder();

            for (int col = 0; col <= width + 1; col++){

                if (row == 0 || row == height + 1){
                    toPrint.append(HORIZONTAL_EDGE_CHAR);
                }
                else if (col == 0 || col == width + 1){
                    toPrint.append(VERTICAL_EDGE_CHAR);
                }
                else{
                    toPrint.append(canvas.getPixel(row, col));
                }
            }

            System.out.println(toPrint.toString());
        }
    }
}
