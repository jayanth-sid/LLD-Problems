package TicTacToe;

public class Board {

    private Peice[][] board;
    protected int filled = 0;
    protected int size;

    public Board(int n) {
        size = n;
        board = new Peice[n][n];
    }

    protected boolean validateMove(int x, int y) {
        if ((x < 0) || (x >= size) || (y < 0) || (y >= size))
            return false;
        if (board[x][y] != null) {
            return false;
        }
        return true;
    }

    protected void putMove(int x, int y, Peice p) {
        board[x][y] = p;
        return;
    }

    protected boolean validateWin(int x, int y, Peice p) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][y] == p) {
                c++;
            }
        }
        if (c == 3)
            return true;
        c = 0;
        for (int i = 0; i < size; i++) {
            if (board[x][i] == p) {
                c++;
            }
        }
        if (c == 3)
            return true;
        c = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][i] == p) {
                c++;
            }
        }
        if (c == 3)
            return true;
        c = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][size - i - 1] == p) {
                c++;
            }
        }
        if (c == 3)
            return true;
        return false;
    }

    protected boolean hasMoves() {
        return filled < 9;
    }

    protected void printboard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("_  ");
                } else {
                    System.out.print(board[i][j].type + "  ");
                }
            }
            System.out.println();
        }
    }
}
