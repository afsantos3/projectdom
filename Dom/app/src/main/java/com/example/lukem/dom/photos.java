package com.example.lukem.dom;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jacob on 3/25/2017.
 */

public class photos extends ArrayList<String> {
    Random rand;

    public void photos() {
        rand = new Random();
        // add all photos here

        this.add("http://apartmentgeeks.net/wp-content/uploads/2013/03/Apartment.jpg");
        this.add("http://harborsidevillage.com/blog/wp-content/uploads/2014/01/Apartment-garages-in-Joppa-MD.png");
        this.add("http://upload.wikimedia.org/wikipedia/commons/e/e8/Apartment_Building.JPG");
        this.add("http://knowitallgroup.com/wp-content/uploads/2013/01/apartment.jpg");
        this.add("http://www.offlineproperty.com/images/property/apartment_Chennai_254.jpeg");
    }

    public String getPhoto(){
        return this.get(rand.nextInt(this.size() - 1));
    }
}
