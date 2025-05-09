package org.example;


import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random = new Random();

    public ComputerPlayer(String symbol) {
        super(symbol);
    }

    @Override
    public int getMove(Board board) {
        // 1. First Move: Take a corner if the board is empty
        if (board.isBoardEmpty()) {
            int[] corners = {0, 2, 6, 8};
            return corners[random.nextInt(corners.length)];
        }

        // 2. Second Move: Take the center if available
        if (board.getMovesMade() == 1 && board.isSpaceEmpty(4)) {
            return 4;
        }

        // 3. Winning Move: Check if computer can win
        int winningMove = canWinOrBlock(board, getSymbol());
        if (winningMove != -1) {
            return winningMove;
        }

        // 4. Blocking Move: Check if human can win
        String opponentSymbol = (getSymbol().equals("X")) ? "O" : "X";
        int blockingMove = canWinOrBlock(board, opponentSymbol);
        if (blockingMove != -1) {
            return blockingMove;
        }

        // 5. Random Move: Choose a random empty spot
        return getRandomEmptySpot(board);
    }

    private int canWinOrBlock(Board board, String symbol) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board.getBoard()[i * 3].equals(symbol) && board.getBoard()[i * 3 + 1].equals(symbol) && board.isSpaceEmpty(i * 3 + 2)) return i * 3 + 2;
            if (board.getBoard()[i * 3].equals(symbol) && board.isSpaceEmpty(i * 3 + 1) && board.getBoard()[i * 3 + 2].equals(symbol)) return i * 3 + 1;
            if (board.isSpaceEmpty(i * 3) && board.getBoard()[i * 3 + 1].equals(symbol) && board.getBoard()[i * 3 + 2].equals(symbol)) return i * 3;
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board.getBoard()[i].equals(symbol) && board.getBoard()[i + 3].equals(symbol) && board.isSpaceEmpty(i + 6)) return i + 6;
            if (board.getBoard()[i].equals(symbol) && board.isSpaceEmpty(i + 3) && board.getBoard()[i + 6].equals(symbol)) return i + 3;
            if (board.isSpaceEmpty(i) && board.getBoard()[i + 3].equals(symbol) && board.getBoard()[i + 6].equals(symbol)) return i;
        }

        // Check diagonals
        if (board.getBoard()[0].equals(symbol) && board.getBoard()[4].equals(symbol) && board.isSpaceEmpty(8)) return 8;
        if (board.getBoard()[0].equals(symbol) && board.isSpaceEmpty(4) && board.getBoard()[8].equals(symbol)) return 4;
        if (board.isSpaceEmpty(0) && board.getBoard()[4].equals(symbol) && board.getBoard()[8].equals(symbol)) return 0;

        if (board.getBoard()[2].equals(symbol) && board.getBoard()[4].equals(symbol) && board.isSpaceEmpty(6)) return 6;
        if (board.getBoard()[2].equals(symbol) && board.isSpaceEmpty(4) && board.getBoard()[6].equals(symbol)) return 4;
        if (board.isSpaceEmpty(2) && board.getBoard()[4].equals(symbol) && board.getBoard()[6].equals(symbol)) return 2;

        return -1; // No winning or blocking move found
    }

    private int getRandomEmptySpot(Board board) {
        int move;
        do {
            move = random.nextInt(9);
        } while (!board.isSpaceEmpty(move));
        return move;
    }
}