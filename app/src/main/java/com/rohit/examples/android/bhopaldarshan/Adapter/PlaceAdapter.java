package com.rohit.examples.android.bhopaldarshan.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlacesViewHolder> {

    private final ArrayList<Place> places;
    private final Context context;

    /**
     * Constructor to initialize the adapter with current context object and Hotels list
     *
     * @param context access to application-specific resources and classes
     * @param places  getting places list
     */
    public PlaceAdapter(ArrayList<Place> places, Context context) {
        this.places = places;
        this.context = context;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * Inflating places fragment layout
     *
     * @param viewGroup ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType  the view type of the new View
     * @return returns a new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new PlacesViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.layout_place_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param placesViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position         The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final PlacesViewHolder placesViewHolder, final int position) {

        //Storing the stable ID for the item at position
        final Place place = places.get(position);

        //Based on item position, storing the data accordingly
        placesViewHolder.placeTitle.setText(place.getPlaceTitle());
        placesViewHolder.placeImg.setImageResource(place.getPlaceImageId());
        placesViewHolder.placeRating.setText(String.valueOf(place.getPlaceRating()));
        placesViewHolder.placeRatingBar.setRating(place.getPlaceRating());
        placesViewHolder.placeType.setText(place.getPlaceType());

        //Click Listener to open a detail intent, displaying more info about places
        placesViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, place, placesViewHolder.placeImg);
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
        return places.size();
    }

    public static class PlacesViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final TextView placeTitle;
        final ImageView placeImg;
        final TextView placeRating;
        final RatingBar placeRatingBar;
        final TextView placeType;
        final CardView cardView;

        PlacesViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            placeTitle = itemView.findViewById(R.id.place_name);
            placeImg = itemView.findViewById(R.id.place_image);
            placeRating = itemView.findViewById(R.id.rating);
            placeRatingBar = itemView.findViewById(R.id.ratingBar);
            placeType = itemView.findViewById(R.id.place_type);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}