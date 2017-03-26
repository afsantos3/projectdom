package com.example.lukem.dom;

import android.text.TextUtils;
import android.util.Log;

import java.awt.font.TextAttribute;
import java.util.ArrayList;
import com.google.gson.Gson;
import org.json.*;

/**
 * Created by jacob on 3/25/2017.
 */

public class houselist {
    house avgHouse;

    ArrayList<house> thisHouseList;

    public houselist(pref_init initial_data) {
        thisHouseList = new ArrayList<house>();
        set_list(make_request());
    }

    public void set_list(String jsonResponse) {
        house listing;
        if(TextUtils.isEmpty(jsonResponse)){
            Log.v("Warning", "JSON_str is empty!");
            return;
        }

        try {
            JSONObject features = new JSONObject(jsonResponse);
            JSONArray options = features.getJSONArray("options");
            JSONObject entry, values;
            for(int i = 0; i < 5 && i < jsonResponse.length(); i++){
                entry = options.getJSONObject(i);
                values = entry.getJSONObject("values");
                listing = new house(
                        values.getDouble("price"),
                        values.getInt("square_footage"),
                        values.getInt("utilities")
                        /* TODO: Add when supported by API
                        , values.getString("type")
                        */
                );
                Log.v("houselist", listing.toString());
            }
        } catch (JSONException e){
            Log.v("Warning", "JSON Exception", e);
            return;
        }

    }

    public String make_request() {
        return "{\"options\": [\n" +
                "    {\n" +
                "      \"key\": 0,\n" +
                "      \"address\": \"1701 NCC Enterprise St.\",\n" +
                "      \"values\": {\n" +
                "        \"price\": 38308,\n" +
                "        \"square_footage\": 17909,\n" +
                "        \"utilities\": 0,\n" +
                "        \"number_bedrooms\": 0,\n" +
                "        \"number_bathrooms\": 2\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"key\": 1,\n" +
                "      \"address\": \"1701 NCC Enterprise St.\",\n" +
                "      \"values\": {\n" +
                "        \"price\": 35744,\n" +
                "        \"square_footage\": 1523,\n" +
                "        \"utilities\": 0,\n" +
                "        \"number_bedrooms\": 2,\n" +
                "        \"number_bathrooms\": 5\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"key\": 2,\n" +
                "      \"address\": \"1701 NCC Enterprise St.\",\n" +
                "      \"values\": {\n" +
                "        \"price\": 216190,\n" +
                "        \"square_footage\": 8043,\n" +
                "        \"utilities\": 1,\n" +
                "        \"number_bedrooms\": 5,\n" +
                "        \"number_bathrooms\": 4\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"key\": 3,\n" +
                "      \"address\": \"1701 NCC Enterprise St.\",\n" +
                "      \"values\": {\n" +
                "        \"price\": 75325,\n" +
                "        \"square_footage\": 5519,\n" +
                "        \"utilities\": 1,\n" +
                "        \"number_bedrooms\": 4,\n" +
                "        \"number_bathrooms\": 0\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"key\": 4,\n" +
                "      \"address\": \"1701 NCC Enterprise St.\",\n" +
                "      \"values\": {\n" +
                "        \"price\": 113001,\n" +
                "        \"square_footage\": 22621,\n" +
                "        \"utilities\": 1,\n" +
                "        \"number_bedrooms\": 3,\n" +
                "        \"number_bathrooms\": 0\n" +
                "      }\n" +
                "    }]}";
    }

    public houselist() {
        thisHouseList = new ArrayList<house>();
        set_list(make_request());
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

