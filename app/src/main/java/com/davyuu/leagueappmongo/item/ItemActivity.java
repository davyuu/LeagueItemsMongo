package com.davyuu.leagueappmongo.item;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.davyuu.leagueappmongo.R;
import com.davyuu.leagueappmongo.models.Item;

public class ItemActivity extends AppCompatActivity {

    private static final String EXTRA_ACTIVITY_ITEM = "item.ItemActivity";
    private Item item;

    public static void startActivity(Activity parentActivity, Item item) {
        Intent intent = new Intent(parentActivity, ItemActivity.class);
        intent.putExtra(EXTRA_ACTIVITY_ITEM, item);

        parentActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity_layout);


        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ACTIVITY_ITEM)) {
            item = intent.getParcelableExtra(EXTRA_ACTIVITY_ITEM);
        }


    }
}
