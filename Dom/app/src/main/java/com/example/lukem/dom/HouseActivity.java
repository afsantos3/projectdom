package com.example.lukem.dom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class HouseActivity extends AppCompatActivity {

    String LOG_TAG = "DOM:HouseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_activity);

        TextView priceText = (TextView) findViewById(R.id.price_variable_field);
        TextView sizeText = (TextView) findViewById(R.id.size_variable_field);
        ImageView houseImageView = (ImageView) findViewById(R.id.house_imageview);
        ImageButton likeButton = (ImageButton) findViewById(R.id.like_button);
        ImageButton dislikeButton = (ImageButton) findViewById(R.id.dislike_button);

        Bundle bundle = getIntent().getExtras();
        house currentHouse = getHouseExtras(bundle);

        sizeText.setText(Integer.toString(currentHouse.square_foot));
        priceText.setText(Double.toString(currentHouse.price));
        houseImageView.setImageResource(R.drawable.dom);

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private house getHouseExtras(Bundle b) {
        return new house(b.getDouble("price"), b.getInt("square_foot"));
    }

    @Override
    public void onBackPressed() {
        Log.v(LOG_TAG, "Back pressed");
         Intent parent = new Intent(HouseActivity.this, MainActivity.class);
        startActivity(parent);
    }
}
