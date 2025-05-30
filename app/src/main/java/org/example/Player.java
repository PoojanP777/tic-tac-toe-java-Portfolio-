package org.example;

public abstract class Player {
    private String symbol;

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public abstract int getMove(Board board);
}