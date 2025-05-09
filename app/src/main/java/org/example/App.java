package org.example;



import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;
        GameStats overallStats = new GameStats(); // To track overall results

        do {
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

            Game game; // Declare game outside the if-else blocks

            if (gameTypeChoice == 1) {
                Player player1 = new HumanPlayer("X");
                Player player2 = new HumanPlayer("O");
                game = new Game(player1, player2);
            } else if (gameTypeChoice == 2) {
                Player humanPlayer = new HumanPlayer("X");
                Player computerPlayer = new ComputerPlayer("O");
                System.out.println("\nOkay, you will go first."); // Implicit: Human goes first
                game = new Game(humanPlayer, computerPlayer);
            } else if (gameTypeChoice == 3) {
                Player humanPlayer = new HumanPlayer("O");
                Player computerPlayer = new ComputerPlayer("X");
                System.out.println("\nGreat! The computer will go first."); // Implicit: Computer goes first
                game = new Game(computerPlayer, humanPlayer);
            } else {
                System.out.println("Invalid selection. Please try again.");
                scanner.close();
                return; // Exit the main method if the input is invalid
            }

            System.out.println("--- About to start the game ---");
            game.play(); // Play the game

            // Update overall stats
            overallStats.incrementHumanWins(game.getGameStats().getHumanWins());
            overallStats.incrementComputerWins(game.getGameStats().getComputerWins());
            overallStats.incrementTies(game.getGameStats().getTies());

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n--- Overall Game Results ---");
        overallStats.displayStats(); // Display the overall statistics
        System.out.println("Thank you for playing!");
        scanner.close();
    }
}