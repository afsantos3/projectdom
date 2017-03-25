package com.example.lukem.dom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HouseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encapsule);

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

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HouseFragment()).commit();
    }
}
