package tictactoe;

import java.util.Scanner;

public class Main {
    static int checkWinner(char[][] match) {
        for (int a = 0; a < 8; a++) {
            int line = 0;

            switch (a) {
                case 0:
                    line = match[0][0] + match[0][1] + match[0][2];
                    break;
                case 1:
                    line = match[1][0] + match[1][1] + match[1][2];
                    break;
                case 2:
                    line = match[2][0] + match[2][1] + match[2][2];
                    break;
                case 3:
                    line = match[0][0] + match[1][0] + match[2][0];
                    break;
                case 4:
                    line = match[0][1] + match[1][1] + match[2][1];
                    break;
                case 5:
                    line = match[0][2] + match[1][2] + match[2][2];
                    break;
                case 6:
                    line = match[0][0] + match[1][1] + match[2][2];
                    break;
                case 7:
                    line = match[0][2] + match[1][1] + match[2][0];
                    break;
            }

            //For X winner
            if (line == 264) {
                return 264;
            }

            // For O winner
            else if (line == 237) {
                return 237;
            }
        }
        return 0;
    }



    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] game = new char[][] {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        System.out.println("---------");
        for (char[] chars : game) {
            System.out.print("| ");
            for (int j = 0; j < game[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        boolean xTurn = true;
        boolean xWins = false;
        boolean oWins = false;
        int spacesLeft = 9;

        while(xWins == oWins && spacesLeft > 0) {

            int corRow = scanner.nextInt();
            int corCol = scanner.nextInt();

            if(corRow > 0 && corRow < 4 && corCol > 0 && corCol < 4) {
                if(xTurn) {
                    if(game[corRow-1][corCol-1] == ' ') {
                        game[corRow-1][corCol-1] = 'X';
                        xTurn = false;
                        spacesLeft--;

                    }
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                else if(game[corRow-1][corCol-1] == ' ') {
                    game[corRow-1][corCol-1] = 'O';
                    xTurn = true;
                    spacesLeft--;
                }
            }
            else {
                System.out.println("Coordinates should be from 1 to 3!");
            }

            System.out.println("---------");
            for (int i = 0; i < game.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < game[0].length; j++) {
                    System.out.print(game[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");


            if(checkWinner(game) == 264){
                xWins = true;
                System.out.println("X wins");
            }
            else if (checkWinner(game) == 237) {
                oWins = true;
                System.out.println("O wins");
            }



        }
        if(!xWins && !oWins)
            System.out.println("Draw");


    }
}