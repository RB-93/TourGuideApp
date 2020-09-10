package com.rohit.examples.android.bhopaldarshan.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.R;

import java.util.ArrayList;

public class PlaceData {

    //Method to fetch values from resources bundle
    public static ArrayList<Place> fetchPlaceData(Context context) {

        ArrayList<Place> places = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Places Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.placeImageId);
        int[] placeImgId = new int[typedArray.length()];
        for (int index = 0; index < placeImgId.length; index++) {
            placeImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store Places Rating
        typedArray = resources.obtainTypedArray(R.array.placeRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.placeName);
        String[] type = resources.getStringArray(R.array.placeType);
        String[] time = resources.getStringArray(R.array.placeTime);
        String[] phone = resources.getStringArray(R.array.placePhone);
        String[] address = resources.getStringArray(R.array.placeAddress);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < placeImgId.length; i++) {
            Place place = new Place(placeImgId[i], name[i], rating[i], type[i], time[i], phone[i], address[i]);
            places.add(place);
        }
        return places;
    }
}