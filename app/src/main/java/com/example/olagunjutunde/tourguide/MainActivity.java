package com.example.olagunjutunde.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.View;

import static android.R.attr.category;
import static android.R.attr.mimeType;

public class MainActivity extends AppCompatActivity {

private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
       CategoryAdapter adapter = new CategoryAdapter(this,getSupportFragmentManager());

        //Hook up ViewPager with the PagerAdapter
        viewPager.setAdapter(adapter);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //Hook up TabLayout with the ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }
}
