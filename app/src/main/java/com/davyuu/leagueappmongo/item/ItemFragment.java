package com.davyuu.leagueappmongo.item;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davyuu.leagueappmongo.LeagueApplication;
import com.davyuu.leagueappmongo.R;

public class ItemFragment extends Fragment {

    private Activity activity;
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
    }

    @Override
    public void onResume() {
        super.onResume();
        LeagueApplication.populateAllItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment_layout, container, false);
        itemRecyclerView = (RecyclerView) view.findViewById(R.id.item_recycler_view);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
        itemRecyclerView.setAdapter(new ItemAdapter(activity));
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
