package com.davyuu.leagueappmongo.Network;

import com.davyuu.leagueappmongo.models.Item;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface LeagueItemService {

    @GET("items")
    Observable<List<Item>> getAllItems();

    @GET("items")
    Observable<Item> getItemById(@Query("id") int id);
}
