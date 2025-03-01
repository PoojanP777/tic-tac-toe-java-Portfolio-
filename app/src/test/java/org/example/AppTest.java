package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testInitialBoardState() {
        App game = new App();
        char[] expectedBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        assertArrayEquals(expectedBoard, game.getBoard());
    }

    @Test
    void testValidMove() {
        App game = new App();
        assertTrue(game.makeMove(1));
    }

    @Test
    void testInvalidMoveOutOfBounds() {
        App game = new App();
        assertFalse(game.makeMove(10));
    }

    @Test
    void testInvalidMoveAlreadyTaken() {
        App game = new App();
        game.makeMove(1);
        assertFalse(game.makeMove(1));
    }

    @Test
    void testWinCondition() {
        App game = new App();
        game.makeMove(1);
        game.makeMove(4);
        game.makeMove(2);
        game.makeMove(5);
        game.makeMove(3);
        assertTrue(game.checkWin());
    }

    @Test
    void testDrawCondition() {
        App game = new App();
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

