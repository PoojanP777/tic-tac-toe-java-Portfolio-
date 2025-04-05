package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameStats stats = new GameStats();

        while (true) {
            Game game = new Game();
            GameLog log = new GameLog();
            boolean gameOver = false;

            while (!gameOver) {
                displayBoard(game.getBoard());
                System.out.print("Player " + game.getCurrentPlayer() + ", enter position (1-9): ");
                int move = scanner.nextInt();

                if (game.makeMove(move)) {
                    log.logMove(move, game.getCurrentPlayer());

                    if (game.checkWin(game.getCurrentPlayer())) {
                        displayBoard(game.getBoard());
                        System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                        log.logResult(String.valueOf(game.getCurrentPlayer()));
                        stats.updateStats(String.valueOf(game.getCurrentPlayer()));
                        gameOver = true;
                    } else if (game.isDraw()) {
                        displayBoard(game.getBoard());
                        System.out.println("It's a draw!");
                        log.logResult("Draw");
                        stats.updateStats("Draw");
                        gameOver = true;
                    } else {
                        game.switchPlayer();
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            // Ask to play again
            System.out.print("Play again? (y/n): ");
            if (!scanner.next().equalsIgnoreCase("y")) break;
        }

        stats.printStats();
        System.out.println("Thanks for playing!");
    }

    private static void displayBoard(char[] board) {
        System.out.println();
        for (int i = 0; i < board.length; i += 3) {
            System.out.printf(" %c | %c | %c\n", board[i], board[i+1], board[i+2]);
            if (i < 6) System.out.println("---+---+---");
        }
        System.out.println();
    }
}
