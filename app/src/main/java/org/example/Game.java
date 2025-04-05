package org.example;

public class Game {
    private char[] board;
    private char currentPlayer;

    public Game() {
        board = new char[9];
        for (int i = 0; i < 9; i++) board[i] = ' ';
        currentPlayer = 'X';
    }

    public char[] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean makeMove(int position) {
        if (position < 1 || position > 9 || board[position - 1] != ' ') return false;
        board[position - 1] = currentPlayer;
        return true;
    }

    public boolean checkWin(char player) {
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // cols
            {0, 4, 8}, {2, 4, 6}             // diagonals
        };
        for (int[] pattern : winPatterns) {
            if (board[pattern[0]] == player &&
                board[pattern[1]] == player &&
                board[pattern[2]] == player) return true;
        }
        return false;
    }

    public boolean isDraw() {
        for (char c : board) if (c == ' ') return false;
        return true;
    }
}
