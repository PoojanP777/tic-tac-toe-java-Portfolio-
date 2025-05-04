package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testComputerPlayerFirstMove() {
        Board board = new Board();
        ComputerPlayer computerPlayer = new ComputerPlayer("X");
        int move = computerPlayer.getMove(board);
        assertTrue(move == 0 || move == 2 || move == 6 || move == 8, "Computer should choose a corner for the first move.");
    }

    @Test
    public void testComputerPlayerSecondMove() {
        Board board = new Board();
        board.makeMove(0, "X"); // Human makes a move
        ComputerPlayer computerPlayer = new ComputerPlayer("O");
        int move = computerPlayer.getMove(board);
        assertEquals(4, move, "Computer should choose the center for the second move if it's available.");
    }

    @Test
    public void testComputerPlayerWinningMove() {
        Board board = new Board();
        board.makeMove(0, "X");
        board.makeMove(1, "X");
        ComputerPlayer computerPlayer = new ComputerPlayer("O");
        board.makeMove(2, "O"); // Computer needs to make a move to not lose.
        board.makeMove(3, "X");
        board.makeMove(4, "X");
        int move = computerPlayer.getMove(board);
        assertEquals(5, move, "Computer should choose the winning move.");
    }

    @Test
    public void testComputerPlayerBlockingMove() {
        Board board = new Board();
        board.makeMove(0, "X");
        board.makeMove(1, "X");
        ComputerPlayer computerPlayer = new ComputerPlayer("O");
        int move = computerPlayer.getMove(board);
        assertEquals(2, move, "Computer should block the opponent's winning move.");
    }

    @Test
    public void testComputerPlayerRandomMove() {
        Board board = new Board();
        board.makeMove(0, "X");
        board.makeMove(1, "X");
        board.makeMove(2,"O");
        board.makeMove(3,"X");
        board.makeMove(4,"O");
        board.makeMove(5,"X");
        board.makeMove(6,"O");
        board.makeMove(7,"X");
        ComputerPlayer computerPlayer = new ComputerPlayer("O");
        int move = computerPlayer.getMove(board);
        assertEquals(8, move, "Computer should make the last move.");
    }
}