package com.rohit.examples.android.bhopaldarshan.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.rohit.examples.android.bhopaldarshan.Model.Shop;
import com.rohit.examples.android.bhopaldarshan.R;

import java.util.ArrayList;

public class ShopData {

    //Method to fetch values from resources bundle
    public static ArrayList<Shop> fetchShopData(Context context) {

        ArrayList<Shop> shops = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Shops Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.shopImgId);
        int[] shopImgId = new int[typedArray.length()];
        for (int index = 0; index < shopImgId.length; index++) {
            shopImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Logic to fetch and store Shops Rating
        typedArray = resources.obtainTypedArray(R.array.shopRating);
        float[] rating = new float[typedArray.length()];
        for (int index = 0; index < rating.length; index++) {
            rating[index] = typedArray.getFloat(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.shopName);
        String[] place = resources.getStringArray(R.array.shopPlace);
        String[] time = resources.getStringArray(R.array.shopTime);
        String[] phone = resources.getStringArray(R.array.shopPhone);
        String[] address = resources.getStringArray(R.array.shopAddress);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < shopImgId.length; i++) {
            Shop shop = new Shop(shopImgId[i], name[i], rating[i], phone[i], place[i], time[i], address[i]);
            shops.add(shop);
        }
        return shops;
    }
}