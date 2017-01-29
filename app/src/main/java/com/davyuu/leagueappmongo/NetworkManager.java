package com.davyuu.leagueappmongo;

import com.davyuu.leagueappmongo.Network.LeagueItemService;
import com.davyuu.leagueappmongo.models.Item;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    String baseUrl = "https://davyuu-nodejs-leagueitems.herokuapp.com/";
    LeagueItemService service;

    public NetworkManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(LeagueItemService.class);
    }

    public void getAllItems(Callback<List<Item>> callback){
        service.getAllItems()
                .enqueue(callback);
    }

    public void getItemById(Callback<Item> callback, int id) {
        service.getItemById(id)
                .enqueue(callback);
    }
}
