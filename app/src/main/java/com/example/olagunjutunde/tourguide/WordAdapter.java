package com.example.olagunjutunde.tourguide;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by OLAGUNJU TUNDE on 11/14/2017.
 */


public class WordAdapter extends ArrayAdapter<Word>
{

    private int mColor;


 public WordAdapter(Context context, List<Word> words,int color){

     super(context,0,words);
     mColor = color;
 }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
       View  listItemView = convertView;
        if(listItemView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
           listItemView =  inflater.inflate(R.layout.list_item, parent, false);
        }



        // Get the Word object located at this position in the list
            Word currentWord = getItem(position);

        // find the text view with id name_text
            TextView name = (TextView) listItemView.findViewById(R.id.name_text);
        //set the CurrentWord name Object on this textView
            name.setText(currentWord.getName());

        // find the text view with id address_text
         TextView address = (TextView) listItemView.findViewById(R.id.address_text);
        //set the CurrentWord address Object on this textView
            address.setText(currentWord.getAddress());

        // find the image view with id image_view
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        //set the CurrentWord image Object on this imageView
            imageView.setImageResource(currentWord.getImgResourceId());

        // Set the theme color for the list item
        RelativeLayout relativeLayout = (RelativeLayout)listItemView.findViewById(R.id.back_ground);

        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(),mColor);

        // Set the background color of the text container View
        relativeLayout.setBackgroundColor(color);


        // Return the whole list item layout  so that it can be shown in
        // the ListView.
        return listItemView;
    }

}
