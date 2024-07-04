package TicTacToe;

import java.util.Scanner;

public class Player {
    public String Name;
    public Peice peice;
    private Scanner sc;

    public Player(String name, char type) {
        this.Name = name;
        this.peice = new Peice(type);
        this.sc = new Scanner(System.in);
    }

    public int[] getMove() {

        int x, y;
        System.out.print(Name + " please enter a move:");
        x = this.sc.nextInt();
        y = this.sc.nextInt();
        int pos[] = { x, y };
        return (pos);
    }
}
