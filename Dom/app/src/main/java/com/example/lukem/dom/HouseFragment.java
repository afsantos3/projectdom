package com.example.lukem.dom;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HouseFragment extends Fragment {

    String LOG_TAG = "DOM:HouseActivity";

    public HouseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.house_activity, container, false);

        super.onCreate(savedInstanceState);

        TextView priceText = (TextView) rootView.findViewById(R.id.price_variable_field);
        TextView sizeText = (TextView) rootView.findViewById(R.id.size_variable_field);
        ImageView houseImageView = (ImageView) rootView.findViewById(R.id.house_imageview);
        ImageButton likeButton = (ImageButton) rootView.findViewById(R.id.like_button);
        ImageButton dislikeButton = (ImageButton) rootView.findViewById(R.id.dislike_button);

    /*
        if(currentHouse != null){
            sizeText.setText(Integer.toString(currentHouse.square_foot));
            priceText.setText(Double.toString(currentHouse.price));
            houseImageView.setImageResource(R.drawable.dom);
        }
        */

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return rootView;
    }

}
