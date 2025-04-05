package org.example;

public class GameStats {
    private int xWins = 0;
    private int oWins = 0;
    private int draws = 0;

    public void updateStats(String result) {
        switch (result) {
            case "X": xWins++; break;
            case "O": oWins++; break;
            case "Draw": draws++; break;
        }
    }

    public void printStats() {
        System.out.println("X Wins: " + xWins);
        System.out.println("O Wins: " + oWins);
        System.out.println("Draws: " + draws);
    }
}
