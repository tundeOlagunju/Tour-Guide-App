package com.example.olagunjutunde.tourguide;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.example.olagunjutunde.tourguide.R.id.mScrollView;

public class DetailsActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        Toolbar toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);


        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        //get the information sent from each fragment as extras
        Bundle extras = getIntent().getExtras();

        int picture = extras.getInt("picture");
        String name = extras.getString("name");
        String address = extras.getString("address");
        String phoneNumber = extras.getString("phoneNumber");
        String description = extras.getString("description");

        ImageView pictureView = (ImageView) findViewById(R.id.detail_image);
        CollapsingToolbarLayout collapsingToolbarLayout  = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        TextView  addressView = (TextView) findViewById(R.id.address);
        TextView  callView = (TextView) findViewById(R.id.call);
        TextView  descriptionView =(TextView)findViewById(R.id.description);


        pictureView.setImageResource(picture);
        collapsingToolbarLayout.setTitle(name);
        collapsingToolbarLayout.setExpandedTitleMarginStart(10);
       collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        addressView.setText(address);
        callView.setText(phoneNumber);
        descriptionView.setText(description);



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case android.R.id.home:
                Intent homeIntent = new Intent(DetailsActivity.this,MainActivity.class);
                startActivity(homeIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
