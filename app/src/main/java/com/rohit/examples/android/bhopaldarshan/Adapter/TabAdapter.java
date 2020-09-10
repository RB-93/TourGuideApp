package com.rohit.examples.android.bhopaldarshan.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of PagerAdapter that represents each page as a Fragment
 * that is persistently kept in the fragment manager as long as the user can return to the page.
 */
public class TabAdapter extends FragmentPagerAdapter {

    // List variable to keep track of FragmentList and FragmentTitle
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * @param position to keep fragment position
     * @return returns the Fragment associated with a specified position.
     */
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    /**
     * @return returns number of fragments views available
     */
    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    /**
     * Called by the ViewPager to obtain a title string to describe the specified page.
     *
     * @param position position of the title requested
     * @return returns title for the requested page
     */
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    /**
     * Call to add Fragment and Tab title
     *
     * @param fragment fragment to add in list
     * @param tabTitle title of each TabLayout corresponding to Fragment
     */
    public void addFragment(Fragment fragment, String tabTitle) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(tabTitle);
    }
}