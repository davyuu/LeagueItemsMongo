package com.davyuu.leagueappmongo.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.davyuu.leagueappmongo.NetworkManager;
import com.davyuu.leagueappmongo.R;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MainViewPagerAdapter mainViewPagerAdapter;
    private NetworkManager networkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);


        setupMainViewPager();
        setupNetworkManager();
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

    private void setupNetworkManager() {
        networkManager = new NetworkManager();
    }

    public NetworkManager getNetworkManager() {
        return networkManager;
    }
}
