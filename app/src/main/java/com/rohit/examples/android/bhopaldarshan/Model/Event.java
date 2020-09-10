package com.rohit.examples.android.bhopaldarshan.Model;

import java.io.Serializable;

/**
 * Model class to get and set Event Data with Adapter
 */
public class Event implements Serializable {
    private final int eventImageId;
    private final String eventDate;
    private final String eventTitle;
    private final String eventTime;
    private final String eventPlace;
    private final String eventUrl;

    public Event(int imageId, String date, String title, String time, String place, String url) {
        this.eventImageId = imageId;
        this.eventDate = date;
        this.eventTitle = title;
        this.eventTime = time;
        this.eventPlace = place;
        this.eventUrl = url;
    }

    public int getEventImageId() {
        return eventImageId;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public String getEventUrl() {
        return eventUrl;
    }
}