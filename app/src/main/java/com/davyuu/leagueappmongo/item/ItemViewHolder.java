package com.davyuu.leagueappmongo.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.davyuu.leagueappmongo.R;
import com.davyuu.leagueappmongo.models.Item;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    TextView itemTextView;


    public ItemViewHolder(View itemView) {
        super(itemView);
        itemTextView = (TextView) itemView.findViewById(R.id.item_name);
    }

    void bindView(Item item){
        itemTextView.setText(item.getItemName());
    }
}
