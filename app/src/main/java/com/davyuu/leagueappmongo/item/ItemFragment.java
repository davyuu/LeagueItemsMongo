package com.davyuu.leagueappmongo.item;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davyuu.leagueappmongo.R;
import com.davyuu.leagueappmongo.main.MainActivity;
import com.davyuu.leagueappmongo.models.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemFragment extends Fragment {

    private Activity activity;
    private ItemAdapter itemAdapter;
    private List<Item> allItems;
    private RecyclerView itemRecyclerView;



    public ItemFragment() {
        // Required empty public constructor
    }

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        setupFragment();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemRecyclerView = (RecyclerView) getActivity().findViewById(R.id.item_recycler_view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_layout, container, false);
        setupRecyclerViews();
        return view;
    }

    private void setupFragment() {
        itemAdapter = new ItemAdapter(activity);
        ((MainActivity) activity)
                .getNetworkManager()
                .getAllItems(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                        allItems = response.body();
                    }

                    @Override
                    public void onFailure(Call<List<Item>> call, Throwable t) {

                    }
                });
    }

    private void setupRecyclerViews() {
        itemRecyclerView.setAdapter(itemAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: 2017-01-22 get db data
        init();
    }

    private void init() {
        Log.d("DAVID", "ITEMS: " + allItems.toString());
    }
}
