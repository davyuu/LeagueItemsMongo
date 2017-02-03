package com.davyuu.leagueappmongo.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Item implements Parcelable{

    @SerializedName("_id")
    private int id;

    @SerializedName("item_name")
    private String itemName;

    @SerializedName("item_total_price")
    private int itemTotalPrice;

    @SerializedName("item_recipe_price")
    private int itemRecipePrice;

    @SerializedName("item_stats")
    private String itemStats;

    @SerializedName("item_image_src")
    private String itemImageSrc;

    public Item(int id, String itemName, int itemTotalPrice, int itemRecipePrice, String itemStats, String itemImageSrc) {
        this.id = id;
        this.itemName = itemName;
        this.itemTotalPrice = itemTotalPrice;
        this.itemRecipePrice = itemRecipePrice;
        this.itemStats = itemStats;
        this.itemImageSrc = itemImageSrc;
    }

    protected Item(Parcel in) {
        id = in.readInt();
        itemName = in.readString();
        itemTotalPrice = in.readInt();
        itemRecipePrice = in.readInt();
        itemStats = in.readString();
        itemImageSrc = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(int itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public int getItemRecipePrice() {
        return itemRecipePrice;
    }

    public void setItemRecipePrice(int itemRecipePrice) {
        this.itemRecipePrice = itemRecipePrice;
    }

    public String getItemStats() {
        return itemStats;
    }

    public void setItemStats(String itemStats) {
        this.itemStats = itemStats;
    }

    public String getItemImageSrc() {
        return itemImageSrc;
    }

    public void setItemImageSrc(String itemImageSrc) {
        this.itemImageSrc = itemImageSrc;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(itemName);
        parcel.writeInt(itemTotalPrice);
        parcel.writeInt(itemRecipePrice);
        parcel.writeString(itemStats);
        parcel.writeString(itemImageSrc);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Item item = (Item) obj;

        if(itemName != null ? !itemName.equals(item.getItemName()) : item.getItemName() != null){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return itemName != null ? itemName.hashCode() : 0;
    }
}
