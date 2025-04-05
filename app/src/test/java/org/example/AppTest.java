package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testValidAndInvalidMoves() {
        Game game = new Game();
        assertTrue(game.makeMove(1));
        assertFalse(game.makeMove(1)); // Already taken
        assertFalse(game.makeMove(10)); // Invalid
    }

    @Test
    void testWinDetection() {
        Game game = new Game();
        game.makeMove(1); // X
        game.switchPlayer();
        game.makeMove(4); // O
        game.switchPlayer();
        game.makeMove(2); // X
        game.switchPlayer();
        game.makeMove(5); // O
        game.switchPlayer();
        game.makeMove(3); // X wins
        assertTrue(game.checkWin('X'));
        assertFalse(game.checkWin('O'));
    }

    @Test
    void testDrawDetection() {
        Game game = new Game();
        int[] moves = {1, 2, 3, 5, 4, 6, 8, 7, 9};
        for (int move : moves) {
            game.makeMove(move);
            if (!game.isDraw()) game.switchPlayer();
        }
        assertTrue(game.isDraw());
        assertFalse(game.checkWin('X'));
        assertFalse(game.checkWin('O'));
    }

    @Test
    void testGameLog() {
        GameLog log = new GameLog();
        log.logMove(1, 'X');
        log.logMove(5, 'O');
        log.logResult("X");
        assertEquals(3, log.getLog().size());
    }
}
