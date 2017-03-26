package com.example.lukem.dom;

import java.util.ArrayList;

/**
 * Created by jacob on 3/25/2017.
 */

public class houselist {
    house avgHouse;

    ArrayList<house> thisHouseList;

    public houselist(pref_init initial_data) {
        thisHouseList = new ArrayList<house>();
        set_list();
    }

    public void set_list() {
        // make fake data here
        house house1;
        house1 = new house(10, 10);
        thisHouseList.add(house1);

        house house2;
        house2 = new house(20, 20);
        thisHouseList.add(house2);
    }

    public houselist() {
        thisHouseList = new ArrayList<house>();
        for(int i = 0; i < 50; i++) {
            thisHouseList.add(new house());
        }
    }

    public house getNextHouse() {
        int end_index = thisHouseList.size() - 1;

        if (end_index == -1) {
            return null;
        }

        house this_house = thisHouseList.get(end_index);
        thisHouseList.remove(end_index);

        return this_house;
    }
    
    public void set_feedback(int like) {
        if(like == 1) {

        } else {

        }
    }
}

