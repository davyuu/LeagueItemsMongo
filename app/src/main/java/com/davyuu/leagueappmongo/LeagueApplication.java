package com.davyuu.leagueappmongo;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.davyuu.leagueappmongo.Network.NetworkManager;
import com.davyuu.leagueappmongo.models.Item;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

public class LeagueApplication extends MultiDexApplication {

    private static SerializedSubject<Item, Item> itemSubject = new SerializedSubject<>(PublishSubject.<Item>create());

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init();
    }

    public static Observable<Item> getItemObservable() {
        return itemSubject.asObservable();
    }

    public static void populateAllItems() {
        NetworkManager.getAllItems(new Subscriber<List<Item>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<Item> items) {
                for (Item item : items) {
                    itemSubject.onNext(item);
                }
            }
        });
    }
}
