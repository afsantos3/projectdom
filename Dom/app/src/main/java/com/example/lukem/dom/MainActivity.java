package com.example.lukem.dom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String LOG_TAG = "DOM:MainActivity";
    String zip;
    String numBeds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText zipEditText = (EditText) findViewById(R.id.zip_edittext);
        final EditText bedroomsEditText = (EditText) findViewById(R.id.bedrooms_edittext);

        zipEditText.setText("38716");
        bedroomsEditText.setText("5");

        Button findListingsButton = (Button) findViewById(R.id.find_button);
        findListingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numBeds = bedroomsEditText.getText().toString();
                zip = zipEditText.getText().toString();

                if ((numBeds.length() > 10) || (numBeds.isEmpty())){
                    Toast.makeText(MainActivity.this, getString(R.string.invalid_input), Toast.LENGTH_SHORT).show();
                    Log.v(LOG_TAG, "numBeds is invalid");
                }
                else if((zip.length() != 5 && zip.length() != 9) || (zip.isEmpty())){
                    Toast.makeText(MainActivity.this, getString(R.string.invalid_zip), Toast.LENGTH_SHORT).show();
                    Log.v(LOG_TAG, "numBeds is invalid");
                }
                else {
                    Intent houseIntent = new Intent(MainActivity.this, HouseActivityEncapsule.class);
                    houseIntent.putExtra("zip", zip);
                    houseIntent.putExtra("numBeds", numBeds);
                    startActivity(houseIntent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Log.v(LOG_TAG, "Back pressed");
        this.finishAffinity();
    }

}
