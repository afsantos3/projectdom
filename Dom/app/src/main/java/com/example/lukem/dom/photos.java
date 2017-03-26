package com.example.lukem.dom;

import android.util.Log;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jacob on 3/25/2017.
 */

public class photos extends ArrayList<String> {
    private Random rand;

    public void photos() {
        rand = new Random();
        // add all photos here

        this.add("http://apartmentgeeks.net/wp-content/uploads/2013/03/Apartment.jpg");
        this.add("http://harborsidevillage.com/blog/wp-content/uploads/2014/01/Apartment-garages-in-Joppa-MD.png");
        this.add("http://upload.wikimedia.org/wikipedia/commons/e/e8/Apartment_Building.JPG");
        this.add("http://knowitallgroup.com/wp-content/uploads/2013/01/apartment.jpg");
        this.add("http://www.offlineproperty.com/images/property/apartment_Chennai_254.jpeg");
        this.add("http://upload.wikimedia.org/wikipedia/commons/1/1a/Bellevue_Apartment_Building.jpg");
        this.add("http://toastdesign.com.au/wp-content/uploads/luxury_apartment_branding.jpg");
        this.add("http://1.bp.blogspot.com/_blHhVE1ARAY/S64XHDckw6I/AAAAAAAAAAk/Y9UTOYSeBc4/s1600/apartment4.jpg");
        this.add("http://www.alphaven.ch/Alphaven%20KITCHEN%20Apartment%20A.jpg");
        this.add("http://www.decorlock.pics/wp-content/uploads/2014/05/luxury-apartment-elevations-Decorating-Design-Ideas.jpg");
        this.add("http://www.hotelmanager.net/wp-content/uploads/2011/06/apartment.jpg");
        this.add("http://www.e-architect.co.uk/images/jpgs/new_york/56th_st_apartment_e060810_5.jpg");


        Log.v("TEMP", Integer.toString(this.size()));
    }

    public String getPhoto(){
        return this.get(rand.nextInt(this.size() - 1));
    }
}