package com.example.snakeandladders;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int players = sc.nextInt();
        String difficulty = sc.next();
        Game g = new Game(n, players, difficulty);
        g.start();
    }
}