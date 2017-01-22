package com.davyuu.leagueappmongo.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.davyuu.leagueappmongo.item.ItemFragment;
import com.davyuu.leagueappmongo.second.SecondFragment;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    public static final int PAGE_ITEM_FRAGMENT = 0;
    public static final int PAGE_SECOND_FRRAGMENT = 1;
    private static final int NUM_PAGES = 2;
    public Fragment[] fragmentList = new Fragment[NUM_PAGES];

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PAGE_ITEM_FRAGMENT:
                if (fragmentList[position] == null) {
                    ItemFragment itemFragment = ItemFragment.newInstance();
                    fragmentList[position] = itemFragment;
                }
                return fragmentList[position];
            case PAGE_SECOND_FRRAGMENT:
                if (fragmentList[position] == null) {
                    SecondFragment secondFragment = SecondFragment.newInstance();
                    fragmentList[position] = secondFragment;
                }
                return fragmentList[position];
            default:
                return ItemFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
