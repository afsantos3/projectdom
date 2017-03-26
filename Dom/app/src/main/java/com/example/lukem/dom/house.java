package com.example.lukem.dom;

/**
 * Created by jacob on 3/25/2017.
 */

import android.util.Log;

import java.util.Random;

public class house {
<<<<<<< HEAD
    public double price;
    public int square_foot;
=======
    private double price;
    private int square_foot;
    private String photo;
    private int utilities;
    private String type;
    private int bedrooms;
    private int bathrooms;
>>>>>>> master

    public double getPrice() {
        return price;
    }

    public int getSquare_foot() {
        return square_foot;
    }

    public String getPhoto() {
        return photo;
    }

    public int getUtilities() {
        return utilities;
    }

    public String getType() {
        return type;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSquare_foot(int square_foot) {
        this.square_foot = square_foot;
    }

<<<<<<< HEAD
=======
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setUtilities(int utilities) {
        this.utilities = utilities;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public house(double price, int square_foot) {
        this.price = price;
        this.square_foot = square_foot;
    }

    public house(double price, int square_foot, int utilities/*, String type*/) {
        this.price = price;
        this.square_foot = square_foot;
        this.utilities = utilities;
        /* TODO: Add when supported by API
        this.type = type;
        */
    }

    //TODO Delete
>>>>>>> master
    public house() {
        Random rand = new Random();
        this.price = rand.nextInt(5000) + 900;
        this.square_foot = rand.nextInt(100000) + 25000;
    }
}
