package com.example.pen;

public class Pen {
    private Ink ink;
    private boolean isOpen;

    public Pen(int capacity) {
        this.ink = new Ink(capacity);
        this.isOpen = false;
    }

    public void start() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Pen opened");
        }
    }

    public void write(int amount) {
        if (!isOpen) {
            System.out.println("Pen is closed");
            return;
        }

        if (ink.getLevel() < amount) {
            System.out.println("Not enough ink");
            return;
        }

        ink.useInk(amount);
        System.out.println("Writing... Ink left: " + ink.getLevel());
    }

    public void refill() {
        ink.refill();
        System.out.println("Pen refilled");
    }

    public void close() {
        isOpen = false;
        System.out.println("Pen closed");
    }
}