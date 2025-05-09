package org.example;


public class GameStats {
    private int humanWins;
    private int computerWins;
    private int ties;

    public GameStats() {
        this.humanWins = 0;
        this.computerWins = 0;
        this.ties = 0;
    }

    public void incrementHumanWins() {
        this.humanWins++;
    }

    public void incrementComputerWins() {
        this.computerWins++;
    }

    public void incrementTies() {
        this.ties++;
    }

    // New methods to increment by a given value
    public void incrementHumanWins(int wins) {
        this.humanWins += wins;
    }

    public void incrementComputerWins(int wins) {
        this.computerWins += wins;
    }

    public void incrementTies(int ties) {
        this.ties += ties;
    }

    public int getHumanWins() {
        return humanWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public int getTies() {
        return ties;
    }

    public void displayStats() {
        System.out.println("Game Stats:");
        System.out.println("Human Wins: " + humanWins);
        System.out.println("Computer Wins: " + computerWins);
        System.out.println("Ties: " + ties);
    }
}