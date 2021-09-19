package com.gameoflife;

import java.util.Random;

public class Board {
    private int nRow;
    private int nCol;
    private CellState[][] board;

    Board(int nRow, int nCol){
        this.nRow = nRow;
        this.nCol = nCol;
        this.board = new CellState[nRow][nCol];
    }

    public void randomInit(){
        Random random = new Random();
        for(int i=0;i<this.nRow;i++){
            for(int j=0;j<this.nCol;j++){
                boolean isAlive = random.nextBoolean();

                if(isAlive) this.board[i][j] = CellState.ALIVE;
                else this.board[i][j] = CellState.DEAD;
            }
        }
    }

    public boolean isOutOfBound(int row, int col){
        boolean rowBound = row < 0 || row >= this.nRow;
        boolean colBound = col < 0 || col >= this.nCol;

        return (rowBound || colBound);
    }

    public int getnRow() {
        return nRow;
    }

    public void setnRow(int nRow) {
        this.nRow = nRow;
    }

    public int getnCol() {
        return nCol;
    }

    public void setnCol(int nCol) {
        this.nCol = nCol;
    }

    public CellState[][] getBoard() {
        return board;
    }

    public void setBoard(CellState[][] board) {
        this.board = board;
    }
}
