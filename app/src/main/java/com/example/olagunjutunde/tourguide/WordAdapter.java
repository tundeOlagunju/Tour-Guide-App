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

       View  listItemView = convertView;

        if(listItemView == null)
        {

            LayoutInflater inflater = LayoutInflater.from(getContext());
           listItemView =  inflater.inflate(R.layout.list_item, parent, false);
        }




            Word currentWord = getItem(position);



            TextView name = (TextView) listItemView.findViewById(R.id.name_text);
            name.setText(currentWord.getName());

            TextView address = (TextView) listItemView.findViewById(R.id.address_text);
            address.setText(currentWord.getAddress());

            ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
            imageView.setImageResource(currentWord.getImgResourceId());

        RelativeLayout relativeLayout = (RelativeLayout)listItemView.findViewById(R.id.back_ground);
        int color = ContextCompat.getColor(getContext(),mColor);
           relativeLayout.setBackgroundColor(color);

        return listItemView;
    }

}
