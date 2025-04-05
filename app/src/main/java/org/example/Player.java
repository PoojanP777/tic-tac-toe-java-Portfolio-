package org.example;

public class Player {
    private final char symbol; // 'X' or 'O'

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
