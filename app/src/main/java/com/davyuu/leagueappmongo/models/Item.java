package com.davyuu.leagueappmongo.models;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("_id")
    int id;

    @SerializedName("item_name")
    String item_name;

    @SerializedName("item_total_price")
    int item_total_price;

    @SerializedName("item_recipe_price")
    int item_recipe_price;

    @SerializedName("item_stats")
    String item_stats;

    @SerializedName("item_image_src")
    String item_image_src;
}
