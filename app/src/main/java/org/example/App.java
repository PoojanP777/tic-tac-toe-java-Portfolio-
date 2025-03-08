package org.example;

public class App {

    public static void main(String[] args) {
        Game game = new Game();
        GameController controller = new GameController(game);
        controller.start();
    }
}
