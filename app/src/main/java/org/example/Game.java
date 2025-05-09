package org.example;



import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private String currentPlayerSymbol;
    private GameLog gameLog; // Use GameLog to store moves
    private GameStats gameStats;
    private boolean gameStarted; // Track if the game has started
    private String humanSymbol;
    private String computerSymbol;

    private static final String RESULT_FILE = "game_results.txt"; // File to store results

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayerSymbol = "X";
        this.gameLog = new GameLog();
        this.gameStats = new GameStats();
        this.gameStarted = false; // Initialize to false
        this.humanSymbol = null;
        this.computerSymbol = null;
        setPlayerSymbols();
    }

    private void setPlayerSymbols() {
        if (player1 instanceof HumanPlayer) {
            humanSymbol = player1.getSymbol();
            if (player2 instanceof ComputerPlayer) {
                computerSymbol = player2.getSymbol();
            }
        } else if (player2 instanceof HumanPlayer) {
            humanSymbol = player2.getSymbol();
            if (player1 instanceof ComputerPlayer) {
                computerSymbol = player1.getSymbol();
            }
        }
    }

    public void play() {
        while (!board.isGameOver()) {
            Player currentPlayer = (currentPlayerSymbol.equals(player1.getSymbol())) ? player1 : player2;

            if (gameStarted) {
                board.displayBoard();
            } else {
                board.displayBoard();
                gameStarted = true;
            }

            int move = currentPlayer.getMove(board);

            if (board.isSpaceEmpty(move)) {
                board.makeMove(move, currentPlayerSymbol);
                gameLog.addMove(currentPlayerSymbol + " moves to " + move);

                if (board.isGameOver()) {
                    board.displayBoard();
                    String winner = board.checkWinner();
                    if (winner != null) {
                        System.out.println("Player " + winner + " wins!");
                        if (winner.equals(humanSymbol)) {
                            gameStats.incrementHumanWins();
                        } else if (winner.equals(computerSymbol)) {
                            gameStats.incrementComputerWins();
                        }
                        writeResultToFile("Player " + winner + " wins!");
                    } else {
                        System.out.println("It's a tie!");
                        gameStats.incrementTies();
                        writeResultToFile("It's a tie!");
                    }
                    gameStats.displayStats();
                } else {
                    switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public String getGameResult() {
        return null; // Not used in this version
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    private void switchPlayer() {
        currentPlayerSymbol = (currentPlayerSymbol.equals(player1.getSymbol())) ? player2.getSymbol() : player1.getSymbol();
    }

    private void writeResultToFile(String result) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RESULT_FILE, true))) {
            writer.println(result);
            writer.println("Game Log:");
            for (String move : gameLog.getMoves()) {
                writer.println("  " + move);
            }
            writer.println("---");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}