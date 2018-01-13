package com.example.olagunjutunde.tourguide;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.example.olagunjutunde.tourguide.R.id.mScrollView;

public class DetailsActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Bundle extras = getIntent().getExtras();

        //int res = extras.getInt("imgResource");
        //String msg = extras.getString("text");

        //ImageView img = (ImageView)   findViewById(R.id.imag);
        //TextView txt = (TextView)findViewById(R.id.txt);

        //img.setImageResource(res);
        //txt.setText(msg);


        int picture = extras.getInt("picture");
        String name = extras.getString("name");
        String address = extras.getString("address");
        String phoneNumber = extras.getString("phoneNumber");
        String description = extras.getString("description");

        ImageView pictureView = (ImageView) findViewById(R.id.image_view);
        TextView  nameView = (TextView) findViewById(R.id.name);
        TextView  addressView = (TextView) findViewById(R.id.address);
        TextView  callView = (TextView) findViewById(R.id.call);
        TextView  descriptionView =(TextView)findViewById(R.id.description);


        pictureView.setImageResource(picture);
        nameView.setText(name);
        addressView.setText(address);
        callView.setText(phoneNumber);
        descriptionView.setText(description);



    }


}
