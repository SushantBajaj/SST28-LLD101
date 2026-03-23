package com.example.snakeandladders;
import java.util.*;
public class Game {
    Board board;
    Dice dice;
    Queue<Player> q;
    int finalPos;

    public Game(int n, int players, String difficulty) {
        board = new Board(n, difficulty);
        dice = new Dice();
        q = new LinkedList<>();
        finalPos = n * n;

        for (int i = 1; i <= players; i++) {
            q.add(new Player("P" + i));
        }
    }

    public void start() {
        while (q.size() > 1) {
            Player curr = q.poll();

            int roll = dice.roll();
            System.out.println(curr.name + " rolled " + roll);

            int next = curr.position + roll;

            if (next > finalPos) {
                System.out.println("No move");
            } else {
                next = board.checkMove(next);
                curr.position = next;
            }

            System.out.println(curr.name + " at " + curr.position);

            if (curr.position == finalPos) {
                System.out.println(curr.name + " wins!");
            } else {
                q.add(curr);
            }
        }

        System.out.println("Game finished");
    }
}