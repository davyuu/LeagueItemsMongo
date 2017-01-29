package com.davyuu.leagueappmongo.item;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class ItemAdapter extends RecyclerView.Adapter {

    private final Activity activity;

    ItemAdapter(Activity activity){
        this.activity = activity;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
