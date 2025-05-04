package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println();
        System.out.println("What kind of game would you like to play?");
        System.out.println("1. Human vs. Human");
        System.out.println("2. Human vs. Computer");
        System.out.println("3. Computer vs. Human");
        System.out.println();
        System.out.print("What is your selection? ");

        int gameTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (gameTypeChoice == 1) {
            Player player1 = new HumanPlayer("X");
            Player player2 = new HumanPlayer("O");
            Game game = new Game(player1, player2);
            game.play();
        } else if (gameTypeChoice == 2) {
            Player humanPlayer = new HumanPlayer("X");
            Player computerPlayer = new ComputerPlayer("O");
            System.out.println("\nOkay, you will go first."); // Implicit: Human goes first
            Game game = new Game(humanPlayer, computerPlayer);
            game.play();
        } else if (gameTypeChoice == 3) {
            Player humanPlayer = new HumanPlayer("O");
            Player computerPlayer = new ComputerPlayer("X");
            System.out.println("\nGreat! The computer will go first."); // Implicit: Computer goes first
            Game game = new Game(computerPlayer, humanPlayer);
            game.play();
        } else {
            System.out.println("Invalid selection. Please try again.");
        }

        scanner.close();
    }
}

