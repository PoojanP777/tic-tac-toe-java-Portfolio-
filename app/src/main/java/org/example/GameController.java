package org.example;

public class GameController {

    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void start() {
        System.out.println("Game starting...");
        game.initialize();
    }
}
