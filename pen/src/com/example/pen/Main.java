package com.example.pen;

public class Main {
    public static void main(String[] args) {
        Pen pen = new Pen(100);

        pen.start();
        pen.write(20);
        pen.write(50);
        pen.refill();
        pen.write(30);
        pen.close();
    }
}