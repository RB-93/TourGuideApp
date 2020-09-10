package com.rohit.examples.android.bhopaldarshan.Data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import com.rohit.examples.android.bhopaldarshan.Model.Event;
import com.rohit.examples.android.bhopaldarshan.R;

import java.util.ArrayList;

public class EventData {

    //Method to fetch values from resources bundle
    public static ArrayList<Event> fetchEventData(Context context) {

        ArrayList<Event> events = new ArrayList<>();
        Resources resources = context.getResources();

        //Logic to fetch and store Events Drawable
        TypedArray typedArray = resources.obtainTypedArray(R.array.eventImgId);
        int[] eventImgId = new int[typedArray.length()];
        for (int index = 0; index < eventImgId.length; index++) {
            eventImgId[index] = typedArray.getResourceId(index, 0);
        }

        //Recycles the TypedArray, to be re-used by a later caller
        typedArray.recycle();

        //Getting values from string-arrays to store data
        String[] name = resources.getStringArray(R.array.eventName);
        String[] date = resources.getStringArray(R.array.eventDate);
        String[] time = resources.getStringArray(R.array.eventTime);
        String[] place = resources.getStringArray(R.array.eventPlace);
        String[] url = resources.getStringArray(R.array.eventUrl);

        //Mapping data set with recycler view items accordingly
        for (int i = 0; i < eventImgId.length; i++) {
            Event event = new Event(eventImgId[i], name[i], date[i], time[i], place[i], url[i]);
            events.add(event);
        }
        return events;
    }
}