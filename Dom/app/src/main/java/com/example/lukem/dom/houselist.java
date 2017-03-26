package com.example.lukem.dom;

import java.util.ArrayList;

/**
 * Created by jacob on 3/25/2017.
 */

public class houselist extends ArrayList<house> {
    house avgHouse;

    public houselist(pref_init initial_data) {
        set_list();
    }

    public void set_list() {
        // make fake data here
        house house1;
        house1 = new house(10, 10);
        this.add(house1);

        house house2;
        house2 = new house(20, 20);
        this.add(house2);
    }

    public houselist() {
        for(int i = 0; i < 50; i++) {
            add(new house());
        }
    }

    public house getNextHouse() {
        int end_index = this.size() - 1;

        if (end_index == -1) {
            return null;
        }

        house this_house = this.get(end_index);
        this.remove(end_index);

        return this_house;
    }

    public void set_feedback(int like) {
        //
    }
}

