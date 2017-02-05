package com.davyuu.leagueappmongo;

import com.davyuu.leagueappmongo.Network.LeagueItemService;
import com.davyuu.leagueappmongo.models.Item;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NetworkManager {

    private static String baseUrl = "https://davyuu-nodejs-leagueitems.herokuapp.com/";
    private static LeagueItemService service;

    public static void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        service = retrofit.create(LeagueItemService.class);
    }

    public static void getAllItems(final Subscriber<List<Item>> itemListSubscriber) {
        new Runnable() {
            @Override
            public void run() {
                service.getAllItems()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(itemListSubscriber);
            }
        }.run();
    }

    public static void getItemById(final Subscriber<Item> itemSubscriber, final int id) {
        new Runnable() {
            @Override
            public void run() {
                service.getItemById(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(itemSubscriber);
            }
        }.run();
    }
}
