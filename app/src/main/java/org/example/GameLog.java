package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameLog {
    private final List<String> log = new ArrayList<>();

    public void logMove(int position, char player) {
        log.add("Player " + player + " moved to position " + position);
    }

    public void logResult(String result) {
        log.add("Result: " + result);
    }

    public List<String> getLog() {
        return log;
    }
}
