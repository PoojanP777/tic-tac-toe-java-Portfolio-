package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testBoardInitialization() {
        Game game = new Game();
        char[] expectedBoard = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    void testMakeMove() {
        Game game = new Game();
        assertTrue(game.makeMove(1));
        assertFalse(game.makeMove(1)); // Should not allow repeated moves
        assertFalse(game.makeMove(10)); // Out of bounds
    }

    @Test
    void testCheckWin() {
        Game game = new Game();
        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(2);
        game.makeMove(5);
        game.makeMove(3);
        assertTrue(game.checkWin());
    }

    @Test
    void testDraw() {
        Game game = new Game();
        game.makeMove(1);
        game.makeMove(2);
        game.makeMove(3);
        game.makeMove(5);
        game.makeMove(4);
        game.makeMove(6);
        game.makeMove(8);
        game.makeMove(7);
        game.makeMove(9);
        assertTrue(game.isDraw());
    }
}
