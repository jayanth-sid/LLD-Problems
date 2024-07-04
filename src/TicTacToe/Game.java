package TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    public Queue<Player> players;
    public Board board;
    public boolean hasWinner;

    public Game() {
        players = new LinkedList<>();
        Player p1 = new Player("Alice", 'X');
        Player p2 = new Player("Bob", 'O');
        players.add(p1);
        players.add(p2);

        board = new Board(3);

    }

    public void startGame() {
        while (board.hasMoves() && !hasWinner) {
            Player currentPlayer = players.remove();
            int move[] = currentPlayer.getMove();
            while (!board.validateMove(move[0], move[1])) {
                System.out.println("Invalid Move please retry");
                move = currentPlayer.getMove();
            }
            board.putMove(move[0], move[1], currentPlayer.peice);
            board.printboard();
            if (board.validateWin(move[0], move[1], currentPlayer.peice)) {
                System.out.println(currentPlayer.Name + " has won the game");
                hasWinner = true;
            }
            players.add(currentPlayer);
        }

        if (!hasWinner)
            System.out.println("No Winner");

    }
}
