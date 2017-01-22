package com.davyuu.leagueappmongo.main;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davyuu.leagueappmongo.R;

import static com.davyuu.leagueappmongo.main.MainViewPagerAdapter.PAGE_ITEM_FRAGMENT;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);


        setupMainViewPager();
    }

    private void setupMainViewPager() {
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // TODO: 2017-01-22  
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
