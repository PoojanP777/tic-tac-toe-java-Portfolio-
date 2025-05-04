package org.example;


public class Board {
    private String[] board;
    private int movesMade;

    public Board() {
        this.board = new String[9];
        for (int i = 0; i < 9; i++) {
            this.board[i] = " ";
        }
        this.movesMade = 0;
    }

    public String[] getBoard() {
        return board;
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + board[i * 3] + " | " + board[i * 3 + 1] + " | " + board[i * 3 + 2] + " |");
            if (i < 2) {
                System.out.println("-------------");
            }
        }
        System.out.println("-------------");
    }

    public boolean isSpaceEmpty(int position) {
        return board[position].equals(" ");
    }

    public void makeMove(int position, String symbol) {
        if (isSpaceEmpty(position)) {
            board[position] = symbol;
            movesMade++;
        }
    }

    public boolean isBoardEmpty() {
        for (String s : board) {
            if (!s.equals(" ")) {
                return false;
            }
        }
        return true;
    }

     public boolean isGameOver() {
        return checkWinner() != null || movesMade == 9;
    }

    public String checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (!board[i * 3].equals(" ") && board[i * 3].equals(board[i * 3 + 1]) && board[i * 3 + 1].equals(board[i * 3 + 2])) {
                return board[i * 3];
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (!board[i].equals(" ") && board[i].equals(board[i + 3]) && board[i + 3].equals(board[i + 6])) {
                return board[i];
            }
        }
        // Check diagonals
        if (!board[0].equals(" ") && board[0].equals(board[4]) && board[4].equals(board[8])) {
            return board[0];
        }
        if (!board[2].equals(" ") && board[2].equals(board[4]) && board[4].equals(board[6])) {
            return board[2];
        }
        return null;
    }

    public int getMovesMade() {
        return movesMade;
    }
}