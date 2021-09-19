package com.gameoflife;

public class GameOfLife {
    private Board board;
    private boolean isInfinite;

    GameOfLife(Board board, boolean isInfinite){
        this.board = board;
        this.isInfinite = isInfinite;
    }

    GameOfLife(int nRow, int nCol, boolean isInfinite){
        this.board = new Board(nRow, nCol);
        this.isInfinite = isInfinite;
        board.randomInit();
    }

    public void nextState(){
        CellState[][] boardState = board.getBoard();
        int nRow = board.getnRow();
        int nCol = board.getnCol();
        int deltaVal[] = {-1, 0, 1};

        for(int i=0;i<nRow;i++){
            for(int j=0;j<nCol;j++){
                int countAlive = 0;
                for(int deltaRow: deltaVal){
                    for(int deltaCol: deltaVal){
                        if(deltaRow == 0 && deltaCol == 0) continue;
                        int currRow = i + deltaRow;
                        int currCol = j + deltaCol;

                        if(board.isOutOfBound(currRow, currCol) && !isInfinite){
                            throw new ArrayIndexOutOfBoundsException("Index out of bound!");
                        }
                        else{
                            //if infinite, just skip
                            if(!board.isOutOfBound(currRow, currCol)){
                                boolean tes = board.isOutOfBound(currRow, currCol);
                                System.out.println(currRow + " " + currCol + " " + tes);
                                if(boardState[currRow][currCol].equals(CellState.ALIVE)) countAlive++;
                            }
                        }
                    }
                }
                if(boardState[i][j].equals(CellState.ALIVE)){
                    if(countAlive < 2 || countAlive > 3) boardState[i][j] = CellState.DEAD;
                }
                else{
                    if(countAlive == 3) boardState[i][j] = CellState.ALIVE;
                }
            }
        }
    }

    public void printState(){
        for(int i=0;i< board.getnRow();i++){
            for(int j=0;j< board.getnCol();j++){
                if(board.getBoard()[i][j].equals(CellState.ALIVE)) System.out.print('v');
                else System.out.print('.');
            }
            System.out.println();
        }
    }
}
