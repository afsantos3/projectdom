package com.example.lukem.dom;

import android.media.Image;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HouseActivity extends AppCompatActivity {

    String LOG_TAG = "DOM:HouseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String numBedsStr;
        String zipStr;
        int zip;
        int numBeds;
        pref_init pe;
        sorter houseFactory;
        house currentHouse;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_activity);

        TextView priceText = (TextView) findViewById(R.id.price_variable_field);
        TextView sizeText = (TextView) findViewById(R.id.size_variable_field);
        ImageView houseImageView = (ImageView) findViewById(R.id.house_imageview);


        Bundle bundle = getIntent().getExtras();
        numBedsStr = bundle.getString("numBeds");
        zipStr = bundle.getString("zip");
        numBeds = Integer.parseInt(numBedsStr);
        zip = Integer.parseInt(zipStr);

        pe = new pref_init(zip, numBeds);
        houseFactory = new sorter(pe);
        currentHouse = houseFactory.get_next_house();

        if(true || currentHouse != null){
            sizeText.setText("100000");
            priceText.setText("999999");
            houseImageView.setImageResource(R.drawable.dom);
        }

    }
}
