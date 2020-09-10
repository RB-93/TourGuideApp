package com.rohit.examples.android.bhopaldarshan.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.rohit.examples.android.bhopaldarshan.Adapter.TabAdapter;
import com.rohit.examples.android.bhopaldarshan.Fragment.EventFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.HotelFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.PlaceFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.RestaurantFragment;
import com.rohit.examples.android.bhopaldarshan.Fragment.ShopFragment;
import com.rohit.examples.android.bhopaldarshan.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fetching view IDs from resource
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Registering TabLayout with FragmentManager
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());

        // Adding Fragment with help of TabLayout adapter
        tabAdapter.addFragment(new HotelFragment(), getString(R.string.hotels));
        tabAdapter.addFragment(new PlaceFragment(), getString(R.string.places));
        tabAdapter.addFragment(new RestaurantFragment(), getString(R.string.restaurants));
        tabAdapter.addFragment(new ShopFragment(), getString(R.string.shoppings));
        tabAdapter.addFragment(new EventFragment(), getString(R.string.events));

        //Setting the Fragments with ViewPager
        viewPager.setAdapter(tabAdapter);

        //Setting up TabLayout with ViewPager
        tabLayout.setupWithViewPager(viewPager);
    }
}