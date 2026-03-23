package com.example.snakeandladders;
import java.util.*;
public class Board {
    int size;
    Map<Integer, Integer> snakes;
    Map<Integer, Integer> ladders;
    Random rand = new Random();

    public Board(int n, String difficulty) {
        this.size = n * n;
        snakes = new HashMap<>();
        ladders = new HashMap<>();

        generate(n);
    }

    private void generate(int n) {
        int count = n;

        while (snakes.size() < count) {
            int head = rand.nextInt(size - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;

            if (!snakes.containsKey(head) && !ladders.containsKey(head)) {
                snakes.put(head, tail);
            }
        }

        while (ladders.size() < count) {
            int start = rand.nextInt(size - 1) + 1;
            int end = rand.nextInt(size - start) + start + 1;

            if (!snakes.containsKey(start) && !ladders.containsKey(start)) {
                ladders.put(start, end);
            }
        }
    }

    public int checkMove(int pos) {
        if (snakes.containsKey(pos)) {
            System.out.println("Snake at " + pos);
            return snakes.get(pos);
        }

        if (ladders.containsKey(pos)) {
            System.out.println("Ladder at " + pos);
            return ladders.get(pos);
        }

        return pos;
    }
}