package org.example;


import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String symbol) {
        super(symbol);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getMove(Board board) {
        board.displayBoard(); // Show the board to the human player
        System.out.print("Player " + getSymbol() + ", enter your move (0-8): ");
        int move = -1;
        while (move < 0 || move > 8) {
            try {
                move = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 8.");
                scanner.next(); // Consume the invalid input
                move = -1; // Reset to loop again
            }
            if (move < 0 || move > 8) {
                System.out.println("Invalid move. Please enter a number between 0 and 8.");
            }
        }
        return move;
    }
}