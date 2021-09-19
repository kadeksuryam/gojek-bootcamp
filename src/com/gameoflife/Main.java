package com.gameoflife;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Number of rows: ");
        int nRow = stdIn.nextInt();
        System.out.print("Number of cols: ");
        int nCol = stdIn.nextInt();
        System.out.print("Is infinite (Y/N): ");
        boolean isInfinite = (stdIn.next().charAt(0) == 'Y');

	    GameOfLife gameOfLife = new GameOfLife(nRow, nCol, isInfinite);

        while(true){
            gameOfLife.printState();

            System.out.print("\nN to nextState and any key to quit: ");
            char cmd = stdIn.next().charAt(0);

            if(cmd == 'N') {
                gameOfLife.nextState();
            }
            else{
                break;
            }
        }
    }
}
