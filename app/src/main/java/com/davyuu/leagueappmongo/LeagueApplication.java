package com.davyuu.leagueappmongo;

import android.support.multidex.MultiDexApplication;

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
        Subscriber<List<Item>> subscriber = new Subscriber<List<Item>>() {
            @Override
            public void onCompleted() {
                itemSubject.onCompleted();
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
        };
        NetworkManager.getAllItems(subscriber);
    }
}
