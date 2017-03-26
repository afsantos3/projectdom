package com.example.lukem.dom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.URL;

public class HouseActivityEncapsule extends AppCompatActivity {

    String LOG_TAG = "DOM:HAEncapsule";

    static final int DISPLAY_HOUSE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.house_activity);
        super.onCreate(savedInstanceState);

        /* TODO: Factor this into the logic for houselist so as to serve
        entries to the user
         */
        HttpRequestAsyncTask task = new HttpRequestAsyncTask();
        URL myUrl = task.makeUrl("https://tradeoff-analytics-nodejs-wisehacks-dom.mybluemix.net/dom");
        task.execute(myUrl);

        String numBedsStr;
        String zipStr;
        int zip;
        int numBeds;
        pref_init pe;
        sorter houseFactory;
        house currentHouse;

        Bundle bundle = getIntent().getExtras();
        numBedsStr = bundle.getString("numBeds");
        zipStr = bundle.getString("zip");
        numBeds = Integer.parseInt(numBedsStr);
        zip = Integer.parseInt(zipStr);

        pe = new pref_init(zip, numBeds);
        houseFactory = new sorter(pe);

        currentHouse = houseFactory.temp_get_fake_house();

        Intent houseActivityIntent = new Intent(HouseActivityEncapsule.this, HouseActivity.class);
        putHouseExtras(houseActivityIntent, currentHouse);
        startActivityForResult(houseActivityIntent, DISPLAY_HOUSE);

        Log.v(LOG_TAG, "END");
    }

    private void putHouseExtras(Intent intent, house h) {
        intent.putExtra("price", h.getPrice());
        intent.putExtra("square_foot", h.getSquare_foot());
        intent.putExtra("url", "http://apartmentgeeks.net/wp-content/uploads/2013/03/Apartment.jpg");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DISPLAY_HOUSE) {
            // TODO: Fix this if(resultCode == )
            Log.v(LOG_TAG, "Resulted");
            this.recreate();
        }
    }

    @Override
    public void onBackPressed() {
        Log.v(LOG_TAG, "Back pressed");
        Intent parent = getParentActivityIntent();
        startActivity(parent);
    }
}
