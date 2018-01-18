package com.example.olagunjutunde.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by OLAGUNJU TUNDE on 11/14/2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

private Context mContext;
    public CategoryAdapter(Context context,FragmentManager fm){
        super(fm);
        mContext = context;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {// view pager asks the fragment pager adapter for the number fragments

        return 4;//adapter returns  4
    }

    @Override
    public Fragment getItem(int position) { // //the view pager asks the adapter for each fragment at each position
        if (position == 0)

        return new HotelsFragment();// adapter  returns fragment at position 0
       if (position == 1)
            return new MuseumFragment();// adapter  returns fragment at position 1
        if (position == 2)
            return new AmusementFragment();// adapter  returns fragment at position 2
        else
            return  new BarBeachesFragment();// adapter  returns fragment at position 3
    }


    // CharSequence...a title for the requested page
    // position...the position of the title requested
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_hotels);
        }
        if (position == 1)
            return mContext.getString(R.string.category_museum);
        if (position == 2)
            return mContext.getString(R.string.category_amusement);
        else
            return mContext.getString(R.string.category_beaches);


    }
    }

