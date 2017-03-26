package com.example.lukem.dom;

import android.util.Log;

import com.ibm.watson.developer_cloud.tradeoff_analytics.v1.TradeoffAnalytics;

/**
 * Created by jacob on 3/25/2017.
 */

public class sorter {
    public houselist house_list;

    public sorter(pref_init this_init) {
        this.house_list = new houselist(this_init);
    }

    public sorter() {
        this.house_list = new houselist();

        TradeoffAnalytics service = new TradeoffAnalytics();
    }

    public void store_feedback(boolean like) {
        // store feedback
    }

    public house get_next_house() {
        return house_list.pop();
    }

    public house temp_get_fake_house(){
        house temp = new house();
        Log.v("TEMP", Double.toString(temp.price));
        Log.v("TEMP", Integer.toString(temp.square_foot));
        return temp;
    }
}
