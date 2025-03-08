package org.example;

class Board {
    private char[] board;

    public Board() {
        reset();
    }

    public void reset() {
        board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public boolean makeMove(int position, char player) {
        if (position < 1 || position > 9 || board[position - 1] == 'X' || board[position - 1] == 'O') {
            return false;
        }
        board[position - 1] = player;
        return true;
    }

    public boolean checkWin(char player) {
        int[][] winConditions = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                {0, 4, 8}, {2, 4, 6}
        };
        for (int[] condition : winConditions) {
            if (board[condition[0]] == player && board[condition[1]] == player && board[condition[2]] == player) {
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

    public void display() {
        System.out.println("\n " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
    }

    public char[] getState() {
        return board.clone();
    }
}
