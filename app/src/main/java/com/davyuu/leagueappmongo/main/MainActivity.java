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

    MainViewPagerAdapter mainViewPagerAdapter;
    List<Item> allItems;
    Item item;

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
        NetworkManager networkManager = new NetworkManager();
        networkManager.getAllItems(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                allItems = response.body();
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
        networkManager.getItemById(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {
                item = response.body();
            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {
            }
        }, 3);
    }
}
