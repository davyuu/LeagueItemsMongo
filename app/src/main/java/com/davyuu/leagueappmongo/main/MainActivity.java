package com.davyuu.leagueappmongo.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.davyuu.leagueappmongo.NetworkManager;
import com.davyuu.leagueappmongo.R;
import com.davyuu.leagueappmongo.models.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MainViewPagerAdapter mainViewPagerAdapter;
    private NetworkManager networkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupMainViewPager();
        setupNetworkManager();
    }

    private void setupMainViewPager() {
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
    }

    private void setupNetworkManager() {
        networkManager = new NetworkManager();
    }

    public NetworkManager getNetworkManager(){
        return networkManager;
    }
}
