package com.davyuu.leagueappmongo.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.davyuu.leagueappmongo.R;

public class MainActivity extends AppCompatActivity {

    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupMainViewPager();
    }

    private void setupMainViewPager() {
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
    }
}
