package com.cs.consoledrawing.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Canvas {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private char [][] board;
    private int width;
    private int height;

    public Canvas() {
        board = new char[0][0];
    }

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;
        board = new char[this.height + 1][this.width + 1];
        resetCanvas();
    }

    public Canvas(Canvas other){
        this.height = other.height;
        this.width = other.width;
        this.board = Arrays.stream(other.board).map(r -> r.clone()).toArray(char[][]::new);
    }

    public void setCanvas(Canvas canvas){
        this.board = canvas.board;
        this.width = canvas.width;
        this.height = canvas.height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void resetCanvas(){
        for (int row = 0; row < height + 1; row ++){
            Arrays.fill(board[row], ' ');
        }
    }

    public void updatePixel(int row, int col, char pixel){
        board[row][col] = pixel;
    }

    public char getPixel(int row, int col){
        return board[row][col];
    }

}
