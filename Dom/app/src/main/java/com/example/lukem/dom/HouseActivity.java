package com.example.lukem.dom;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class HouseActivity extends AppCompatActivity {

    String LOG_TAG = "DOM:HouseActivity";
    ImageView houseImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.house_activity);

        DownloadImageTask task;

        TextView priceText = (TextView) findViewById(R.id.price_variable_field);
        TextView sizeText = (TextView) findViewById(R.id.size_variable_field);
        ImageButton likeButton = (ImageButton) findViewById(R.id.like_button);
        ImageButton dislikeButton = (ImageButton) findViewById(R.id.dislike_button);
        houseImageView = (ImageView) findViewById(R.id.house_imageview);

        Bundle bundle = getIntent().getExtras();
        final String photoUrl = bundle.getString("url");
        if (!photoUrl.isEmpty()) {
            // Update the database
            task = new DownloadImageTask();
            task.execute(task.makeUrl(photoUrl));
        }

        house currentHouse = getHouseExtras(bundle);

        sizeText.setText(Integer.toString(currentHouse.getSquare_foot()));
        priceText.setText(Double.toString(currentHouse.getPrice()));

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
        return new house(
                b.getDouble("price"),
                b.getInt("square_foot"));
    }

    @Override
    public void onBackPressed() {
        Log.v(LOG_TAG, "Back pressed");
        Intent parent = new Intent(HouseActivity.this, MainActivity.class);
        startActivity(parent);
    }

    private class DownloadImageTask extends AsyncTask<URL, Void, Drawable> {
        @Override
        protected Drawable doInBackground(URL... urls) {
            try {
                InputStream inputStream = (InputStream) urls[0].getContent();
                Drawable housePhoto = Drawable.createFromStream(inputStream, "web");
                return housePhoto;
            } catch (Exception e) {
                Log.v(LOG_TAG, "Malformed URL or IOException", e);
                return null;
            }
        }

        protected void onPostExecute(Drawable resultDrawable) {
            houseImageView.setImageDrawable(resultDrawable);
        }

        private URL makeUrl(String urlString) {
            URL res_url;
            try {
                res_url = new URL(urlString);
            } catch (MalformedURLException exc) {
                Log.e("Error", "Couldn't make url from string", exc);
                return null;
            }
            return res_url;
        }
    }
}
