package com.example.lukem.dom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HouseActivityEncapsule extends AppCompatActivity {

    String LOG_TAG = "DOM:HAEncapsule";

    static final int DISPLAY_HOUSE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
<<<<<<< HEAD

=======
>>>>>>> master
        setContentView(R.layout.house_activity);
        super.onCreate(savedInstanceState);

        String numBedsStr;
        String zipStr;
        int zip;
        int numBeds;
        pref_init pe;
<<<<<<< HEAD
        sorter houseFactory;
=======
        houselist houseFactory;
>>>>>>> master
        house currentHouse;

        Bundle bundle = getIntent().getExtras();
        numBedsStr = bundle.getString("numBeds");
        zipStr = bundle.getString("zip");
        numBeds = Integer.parseInt(numBedsStr);
        zip = Integer.parseInt(zipStr);

        pe = new pref_init(zip, numBeds);
<<<<<<< HEAD
        houseFactory = new sorter(pe);

        currentHouse = houseFactory.temp_get_fake_house();

        Intent houseActivityIntent = new Intent(HouseActivityEncapsule.this, HouseActivity.class);
        putHouseExtras(houseActivityIntent, currentHouse);
=======
        houseFactory = new houselist(pe);

        currentHouse = houseFactory.getNextHouse();

        Intent houseActivityIntent = new Intent(HouseActivityEncapsule.this, HouseActivity.class);

        putHouseExtras(houseActivityIntent, currentHouse);

>>>>>>> master
        startActivityForResult(houseActivityIntent, DISPLAY_HOUSE);

        Log.v(LOG_TAG, "END");
    }

    private void putHouseExtras(Intent intent, house h) {
<<<<<<< HEAD
        intent.putExtra("price", h.price);
        intent.putExtra("square_foot", h.square_foot);
=======
        intent.putExtra("price", h.getPrice());
        intent.putExtra("square_foot", h.getSquare_foot());
        intent.putExtra("url", "http://apartmentgeeks.net/wp-content/uploads/2013/03/Apartment.jpg");
>>>>>>> master
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == DISPLAY_HOUSE) {
            Log.v(LOG_TAG, "Returned to encapsule");
            this.recreate();
        }
    }

    @Override
    public void onBackPressed() {
        Log.v(LOG_TAG, "Back pressed");
        Intent parent = getParentActivityIntent();
        startActivity(parent);
    }
<<<<<<< HEAD
=======

>>>>>>> master
}
