package com.davyuu.leagueappmongo.item;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.davyuu.leagueappmongo.LeagueApplication;
import com.davyuu.leagueappmongo.R;
import com.davyuu.leagueappmongo.models.Item;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

public class ItemAdapter extends RecyclerView.Adapter {

    public static final int ITEM_VIEW_TYPE = 0;

    private final Activity activity;
    private Subscriber<Item> itemSubscriber;
    private List<Item> itemList = new ArrayList<>();

    ItemAdapter(Activity activity) {
        this.activity = activity;
        setupSubscription();
    }

    private void setupSubscription() {
        itemSubscriber = new Subscriber<Item>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Item item) {
                if (item != null && !itemList.contains(item)) {
                    int position = itemList.size();
                    for (int i = 0; i < itemList.size(); i++) {
                        if (item.getItemName().compareToIgnoreCase(itemList.get(i).getItemName()) < 0) {
                            position = i;
                            break;
                        }
                    }
                    itemList.add(item);
                    notifyItemInserted(position);
                }
            }
        };
        LeagueApplication.getItemObservable().subscribe(itemSubscriber);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(activity.getApplicationContext(), R.layout.item_view, null);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).bindView(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    void onDestroy() {
        if (itemSubscriber != null) {
            itemSubscriber.unsubscribe();
        }
    }
}
