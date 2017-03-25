package com.example.lukem.dom;

import java.util.ArrayList;

/**
 * Created by jacob on 3/25/2017.
 */

public class houselist extends ArrayList<house> {
    public houselist(pref_init initial_data) {
        // make fake data here
        house house1;
        house1 = new house(10, 10);
        this.add(house1);

        house house2;
        house2 = new house(20, 20);
        this.add(house2);
    }
}
