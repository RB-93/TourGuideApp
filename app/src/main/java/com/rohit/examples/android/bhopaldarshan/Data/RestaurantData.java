package com.rohit.examples.android.bhopaldarshan.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.R;

import java.util.ArrayList;

public class RestaurantData {

    //Method to fetch values from resources bundle
    public static ArrayList<Restaurant> fetchRestaurantData(Context context) {

        ArrayList<Restaurant> restaurants = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Restaurants Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.restoImgId);
        int[] restoImgId = new int[typedArray.length()];
        for (int index = 0; index < restoImgId.length; index++) {
            restoImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store Restaurants Rating
        typedArray = resources.obtainTypedArray(R.array.restoRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.restoName);
        String[] time = resources.getStringArray(R.array.restoTime);
        String[] phone = resources.getStringArray(R.array.restoPhone);
        String[] type = resources.getStringArray(R.array.restoType);
        String[] address = resources.getStringArray(R.array.restoAddress);
        String[] url = resources.getStringArray(R.array.restoUrl);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < restoImgId.length; i++) {
            Restaurant restaurant = new Restaurant(restoImgId[i], name[i], rating[i], type[i], phone[i], time[i], address[i], url[i]);
            restaurants.add(restaurant);
        }
        return restaurants;
    }
}