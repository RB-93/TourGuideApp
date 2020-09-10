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

import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.R;
import com.rohit.examples.android.bhopaldarshan.Utils.Utils;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private final Context context;
    private final ArrayList<Restaurant> restaurants;

    /**
     * Constructor to initialize the adapter with current context object and Restaurants list
     *
     * @param context     access to application-specific resources and classes
     * @param restaurants Getting restaurants list
     */
    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
    }

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item
     * Inflating restaurants fragment layout
     *
     * @param viewGroup ViewGroup into which the new View will be added after it is bound to an adapter position
     * @param viewType  the view type of the new View
     * @return returns a new ViewHolder that holds a View of the given view type
     */
    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new RestaurantViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_restaurant_fragment, viewGroup, false));
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     *
     * @param restaurantViewHolder which should be updated to represent the contents of the item at the given position in the data set
     * @param position             The position of the item within the adapter's data set
     */
    @Override
    public void onBindViewHolder(@NonNull final RestaurantViewHolder restaurantViewHolder, int position) {

        //Storing the stable ID for the item at position
        final Restaurant restaurant = restaurants.get(position);

        //Based on item position, storing the data accordingly
        restaurantViewHolder.restoImg.setImageResource(restaurant.getRestaurantImageId());
        restaurantViewHolder.restoTitle.setText(restaurant.getRestaurantTitle());
        restaurantViewHolder.restoType.setText(restaurant.getRestaurantType());
        restaurantViewHolder.restoRating.setText(String.valueOf(restaurant.getRestaurantRating()));
        restaurantViewHolder.restoRatingBar.setRating(restaurant.getRestaurantRating());

        //Click Listener to open a detail intent, displaying more info about restaurants
        restaurantViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.detailIntent(context, restaurant, restaurantViewHolder.restoImg);
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
        return restaurants.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {

        // Variable declaration for views available on screen
        final ImageView restoImg;
        final TextView restoTitle;
        final TextView restoType;
        final TextView restoRating;
        final RatingBar restoRatingBar;
        final CardView cardView;

        RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);

            // Fetching view IDs for view elements from resource
            restoImg = itemView.findViewById(R.id.restaurant_image);
            restoTitle = itemView.findViewById(R.id.restaurant_name);
            restoType = itemView.findViewById(R.id.restaurant_type);
            restoRating = itemView.findViewById(R.id.rating);
            restoRatingBar = itemView.findViewById(R.id.ratingBar);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}