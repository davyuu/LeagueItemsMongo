package com.davyuu.leagueappmongo.Network;

import com.davyuu.leagueappmongo.models.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LeagueItemService {

    @GET("items")
    Call<List<Item>> getAllItems();

    @GET("items")
    Call<Item> getItemById(@Query("id") int id);
}
