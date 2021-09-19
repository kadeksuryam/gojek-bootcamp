package com.gameoflife;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;

    public static Cell of(int row, int col, CellState cellState){
        return new Cell(row, col, cellState);
    }

    private Cell(int row, int col, CellState cellState){
        this.row = row;
        this.col = col;
        this.cellState = cellState;
    }

}
