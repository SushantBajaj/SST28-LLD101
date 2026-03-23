package com.example.pen;

public class Ink {
    private int capacity;
    private int level;

    public Ink(int capacity) {
        this.capacity = capacity;
        this.level = capacity;
    }

    public int getLevel() {
        return level;
    }

    public void useInk(int amount) {
        level -= amount;
    }

    public void refill() {
        level = capacity;
    }
}