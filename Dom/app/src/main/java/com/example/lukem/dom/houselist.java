package com.example.lukem.dom;

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
        set_list();
    }

    public void set_list() {
        

    }

    public String make_request() {
        return "\"options\": [\n" +
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
                "    },}";
    }

    public houselist() {
        thisHouseList = new ArrayList<house>();
        set_list();
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

