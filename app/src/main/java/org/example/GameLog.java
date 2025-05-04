package org.example;



import java.util.ArrayList;
import java.util.List;

public class GameLog {
    private List<String> moves;

    public GameLog() {
        this.moves = new ArrayList<>();
    }

    public void addMove(String move) {
        this.moves.add(move);
    }

    public List<String> getMoves() {
        return moves;
    }

    public void displayLog() {
        System.out.println("Game Log:");
        for (int i = 0; i < moves.size(); i++) {
            System.out.println((i + 1) + ". " + moves.get(i));
        }
    }
}