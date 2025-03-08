package org.example;

public class Game {

    private char[] board = new char[9];
    private char currentPlayer = 'X';

    public Game() {
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
        currentPlayer = 'X';
    }

    public char[] getBoard() {
        return board;
    }

    public boolean makeMove(int position) {
        if (position < 1 || position > 9 || board[position - 1] != ' ') {
            return false; // Invalid move
        }
        board[position - 1] = currentPlayer;
        switchPlayer();
        return true;
    }

    public boolean checkWin() {
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]] != ' ' &&
                board[pattern[0]] == board[pattern[1]] &&
                board[pattern[0]] == board[pattern[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (char c : board) {
            if (c == ' ') {
                return false;
            }
        }
        return !checkWin();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
