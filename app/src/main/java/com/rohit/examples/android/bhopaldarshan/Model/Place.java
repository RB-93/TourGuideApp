package com.rohit.examples.android.bhopaldarshan.Model;

import java.io.Serializable;

/**
 * Model class to get and set Place Data with Adapter
 */
public class Place implements Serializable {
    private final int placeImageId;
    private final String placeTitle;
    private final float placeRating;
    private final String placeType;
    private final String placeTime;
    private final String placePhone;
    private final String placeLocation;

    public Place(int imageId, String title, float rating, String type, String time, String phone, String location) {
        this.placeImageId = imageId;
        this.placeTitle = title;
        this.placeRating = rating;
        this.placeType = type;
        this.placePhone = phone;
        this.placeTime = time;
        this.placeLocation = location;
    }

    public int getPlaceImageId() {
        return placeImageId;
    }

    public String getPlaceTitle() {
        return placeTitle;
    }

    public float getPlaceRating() {
        return placeRating;
    }

    public String getPlaceType() {
        return placeType;
    }

    public String getPlacePhone() {
        return placePhone;
    }

    public String getPlaceTime() {
        return placeTime;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }
}