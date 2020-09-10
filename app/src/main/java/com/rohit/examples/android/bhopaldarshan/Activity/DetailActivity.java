package com.rohit.examples.android.bhopaldarshan.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.rohit.examples.android.bhopaldarshan.Fragment.HotelDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.PlaceDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.RestaurantDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.ShopDetailFragment;
import com.rohit.examples.android.bhopaldarshan.Model.Hotel;
import com.rohit.examples.android.bhopaldarshan.Model.Place;
import com.rohit.examples.android.bhopaldarshan.Model.Restaurant;
import com.rohit.examples.android.bhopaldarshan.Model.Shop;
import com.rohit.examples.android.bhopaldarshan.R;

public class DetailActivity extends AppCompatActivity {

    //Declaring a string to hold extra data passed through intent between MainActivity and DetailActivity
    public static final String INTENT_EXTRA = "extras";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Getting intent from MainActivity
        Object object = getIntent().getSerializableExtra(INTENT_EXTRA);
        Fragment fragment = null;

        //Verifying object type obtained from intent and instantiating fragments accordingly
        if (object instanceof Hotel) {
            fragment = HotelDetailFragment.newInstance((Hotel) object);
        } else if (object instanceof Place) {
            fragment = PlaceDetailFragment.newInstance((Place) object);
        } else if (object instanceof Shop) {
            fragment = ShopDetailFragment.newInstance((Shop) object);
        } else if (object instanceof Restaurant) {
            fragment = RestaurantDetailFragment.newInstance((Restaurant) object);
        }

        //Using fragment manager that creates a transaction to replace the container with required fragment
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    /**
     * Called whenever the user chooses to navigate Up within your application's activity hierarchy from the action bar
     *
     * @return true if Up navigation completed successfully and this Activity was finished, false otherwise
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}