package tictactoe;

import java.util.Scanner;

public class Main2 {
    static String checkWinner(char[][] match) {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = String.valueOf(match[0][0] + match[0][1] + match[0][2]);
                    break;
                case 1:
                    line = String.valueOf(match[1][0] + match[1][1] + match[1][2]);
                    break;
                case 2:
                    line = String.valueOf(match[2][0] + match[2][1] + match[2][2]);
                    break;
                case 3:
                    line = String.valueOf(match[0][0] + match[1][0] + match[2][0]);
                    break;
                case 4:
                    line = String.valueOf(match[0][1] + match[1][1] + match[2][1]);
                    break;
                case 5:
                    line = String.valueOf(match[0][2] + match[1][2] + match[2][2]);
                    break;
                case 6:
                    line = String.valueOf(match[0][0] + match[1][1] + match[2][2]);
                    break;
                case 7:
                    line = String.valueOf(match[0][2] + match[1][1] + match[2][0]);
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        return "none";
    }



    public static void main2 (String[] args) {
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

        while(xWins == oWins) {

            int corRow = scanner.nextInt();
            int corCol = scanner.nextInt();

            if(corRow > 0 && corRow < 4 && corCol > 0 && corCol < 4) {
                if(xTurn) {
                    if(game[corRow-1][corCol-1] == ' ') {
                        game[corRow-1][corCol-1] = 'X';
                        xTurn = false;

                    }
                    else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
                else if(game[corRow-1][corCol-1] == ' ') {
                    game[corRow-1][corCol-1] = 'O';
                    xTurn = true;
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

            if(checkWinner(game) == "X"){
                xWins = true;
            }
            else if (checkWinner(game) == "O") {
                oWins = true;
            }
        }

    }
}