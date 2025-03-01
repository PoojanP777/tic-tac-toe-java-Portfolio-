package org.example;

import java.util.Scanner;

public class App {
    private char[] board;
    private char currentPlayer;
    private boolean gameRunning;

    public App() {
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        currentPlayer = 'X';
        gameRunning = true;
    }

    public void printBoard() {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }

    public boolean makeMove(int position) {
        if (position < 1 || position > 9 || board[position - 1] == 'X' || board[position - 1] == 'O') {
            return false;
        }
        board[position - 1] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]] == currentPlayer &&
                board[condition[1]] == currentPlayer &&
                board[condition[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (char c : board) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void resetGame() {
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        currentPlayer = 'X';
        gameRunning = true;
    }

    public char[] getBoard() {  // Added method to fix test case
        return board.clone();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        while (gameRunning) {
            printBoard();
            System.out.print("\nPlayer " + currentPlayer + ", enter your move (1-9): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                scanner.next();
                continue;
            }

            int move = scanner.nextInt();
            if (!makeMove(move)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (checkWin()) {
                printBoard();
                System.out.println("\nPlayer " + currentPlayer + " wins!");
                gameRunning = false;
            } else if (isDraw()) {
                printBoard();
                System.out.println("\nIt's a draw!");
                gameRunning = false;
            } else {
                switchPlayer();
            }

            if (!gameRunning) {
                System.out.print("\nWould you like to play again? (yes/no): ");
                scanner.nextLine();
                String playAgain = scanner.nextLine().trim().toLowerCase();
                if (playAgain.equals("yes")) {
                    resetGame();
                } else {
                    System.out.println("Goodbye!");
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new App().playGame();
    }
}
