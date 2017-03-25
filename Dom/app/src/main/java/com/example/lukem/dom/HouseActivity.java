package com.example.lukem.dom;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class HouseActivity extends AppCompatActivity {

    String LOG_TAG = "DOM:HouseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String numBedsStr;
        String zipStr;
        int zip;
        int numBeds;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_activity);

        Bundle bundle = getIntent().getExtras();
        numBedsStr = bundle.getString("numBeds");
        zipStr = bundle.getString("zip");
        numBeds = Integer.parseInt(numBedsStr);
        zip = Integer.parseInt(zipStr);

        Log.v(LOG_TAG, numBedsStr);
        Log.v(LOG_TAG, zipStr);



    }
}
