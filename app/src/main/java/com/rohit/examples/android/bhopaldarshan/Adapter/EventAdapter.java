package com.rohit.examples.android.bhopaldarshan.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rohit.examples.android.bhopaldarshan.Model.Event;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private final Context context;
    private final ArrayList<Event> events;

    /**
     * Constructor to initialize the adapter with current context object and Events list
     *
     * @param context access to application-specific resources and classes
     * @param events  getting events list
     */
    public EventAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * Inflating events fragment layout
     *
     * @param viewGroup ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType  the view type of the new View
     * @return returns a new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new EventViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.layout_event_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param eventViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position        The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final EventViewHolder eventViewHolder, int position) {
        //Storing the stable ID for the item at position
        final Event event = events.get(position);

        //Based on item position, storing the data accordingly
        eventViewHolder.eventDate.setText(event.getEventDate());
        eventViewHolder.eventTitle.setText(event.getEventTitle());
        eventViewHolder.eventImg.setImageResource(event.getEventImageId());
        eventViewHolder.eventTime.setText(event.getEventTime());
        eventViewHolder.eventPlace.setText(event.getEventPlace());

        //Click Listener to open a web intent, displaying more info about events
        eventViewHolder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.websiteIntent(context, event.getEventUrl());
            }
        });
    }

    /**
     * Method to count number of items in data set
     *
     * @return returns the total number of items in the data set held by the adapter
     */
    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView eventImg;
        final TextView eventDate;
        final TextView eventTitle;
        final TextView eventTime;
        final TextView eventPlace;
        final ConstraintLayout constraintLayout;

        EventViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            eventImg = itemView.findViewById(R.id.eventImg);
            eventDate = itemView.findViewById(R.id.event_date);
            eventTitle = itemView.findViewById(R.id.event_name);
            eventTime = itemView.findViewById(R.id.event_time);
            eventPlace = itemView.findViewById(R.id.event_place);
            constraintLayout = itemView.findViewById(R.id.parent);
        }
    }
}