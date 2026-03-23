package com.example.snakeandladders;

import java.util.*;

public class Dice {
    Random r = new Random();

    public int roll() {
        return r.nextInt(6) + 1;
    }
}