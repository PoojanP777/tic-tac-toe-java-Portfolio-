package org.example;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private String currentPlayerSymbol;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayerSymbol = "X"; // Start with X
    }

    public void play() {
        // ... (rest of your Game.java code, but adapted to use Player objects)
        while (!board.isGameOver()) {
            board.displayBoard(); // Assuming you have this.

            Player currentPlayer;
            if (currentPlayerSymbol.equals(player1.getSymbol()))
            {
                currentPlayer = player1;
            }
            else{
                currentPlayer = player2;
            }

            int move = currentPlayer.getMove(board);

            if (board.isSpaceEmpty(move)) {
                board.makeMove(move, currentPlayerSymbol);

                if (board.isGameOver()) {
                    board.displayBoard();
                    if (board.checkWinner() != null)
                    {
                         System.out.println("Player " + board.checkWinner() + " wins!");
                    }
                    else{
                        System.out.println("It's a tie!");
                    }

                }
                else{
                    switchPlayer();
                }

            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private void switchPlayer() {
        currentPlayerSymbol = (currentPlayerSymbol.equals(player1.getSymbol())) ? player2.getSymbol() : player1.getSymbol();
    }
}