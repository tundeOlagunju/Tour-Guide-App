package com.example.olagunjutunde.tourguide;

/**
 * Created by OLAGUNJU TUNDE on 11/14/2017.
 */

public class Word {


    private String mName;

    private String mAddress;

    private int mImgResourceId;




    public Word(String name,String address,int imgResourceId){

        mName = name;
        mAddress = address;
        mImgResourceId =imgResourceId;


    }

    public String getName(){
        return mName;
    }

    public String getAddress(){
        return mAddress;
    }

    public int getImgResourceId(){
        return mImgResourceId;
    }


}
