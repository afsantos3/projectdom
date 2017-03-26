package com.example.lukem.dom;

/**
 * Created by jacob on 3/25/2017.
 */

import java.util.Random;

public class house {
    public double price;
    public int square_foot;

    public house(double price, int square_foot) {
        this.price = price;
        this.square_foot = square_foot;
    }

    public house() {
        Random rand = new Random();
        this.price = rand.nextInt(5000) + 900;
        this.square_foot = rand.nextInt(100000) + 25000;
    }
}
