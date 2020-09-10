package com.rohit.examples.android.bhopaldarshan.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.rohit.examples.android.bhopaldarshan.Model.Hotel;
import com.rohit.examples.android.bhopaldarshan.R;

import java.util.ArrayList;

public class HotelData {

    //Method to fetch values from resources bundle
    public static ArrayList<Hotel> fetchHotelData(Context context) {

        ArrayList<Hotel> hotels = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Hotels Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.hotelImgID);
        int[] hotelImgId = new int[typedArray.length()];
        for (int index = 0; index < hotelImgId.length; index++) {
            hotelImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store Hotels Rating
        typedArray = resources.obtainTypedArray(R.array.hotelRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.hotelName);
        String[] type = resources.getStringArray(R.array.hotelType);
        String[] phone = resources.getStringArray(R.array.hotelPhone);
        String[] address = resources.getStringArray(R.array.hotelAddress);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < hotelImgId.length; i++) {
            Hotel hotel = new Hotel(hotelImgId[i], name[i], rating[i], phone[i], type[i], address[i]);
            hotels.add(hotel);
        }
        return hotels;
    }
}