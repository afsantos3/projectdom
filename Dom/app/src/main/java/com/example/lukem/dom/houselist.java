package com.example.lukem.dom;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;
import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.model.Problem;

import java.sql.Wrapper;
import java.util.ArrayList;
import com.google.gson.Gson;

/**
 * Created by jacob on 3/25/2017.
 */

public class houselist {

    avg_scores avgScores;
    house currHouse;

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
            set_list();
            getNextHouse();
        }

        house this_house = thisHouseList.get(end_index);
        thisHouseList.remove(end_index);

        currHouse = this_house;
        return this_house;
    }
    public String convert_to_gson(){
        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(avgScores);
        return jsonElement.getAsString();
    }
    public void set_feedback(int like) {
        if(like == 1) {
            //set total
            avgScores.setLikes(avgScores.getLikes() + 1);
            avgScores.setBath_total(avgScores.getBath_total() + currHouse.getBathrooms());
            avgScores.setBed_total(avgScores.getBed_total() + currHouse.getBedrooms());
            avgScores.setPrice_total(avgScores.getPrice_total() + currHouse.getPrice());
            avgScores.setUt_total(avgScores.getUt_total() + currHouse.getUtilities());
            avgScores.setSqft_total(avgScores.getSqft_total() + currHouse.getSquare_foot());

            //set avgs
            avgScores.setBath_avg(avgScores.getBath_total() / avgScores.getLikes());
            avgScores.setBed_avg(avgScores.getBed_total() / avgScores.getLikes());
            avgScores.setPrice_avg(avgScores.getPrice_total() / avgScores.getLikes());
            avgScores.setUt_avg(avgScores.getUt_total() / avgScores.getLikes());
            avgScores.setSqft_avg(avgScores.getSqft_total() / avgScores.getLikes());

            convert_to_gson();
        }
    }
}

