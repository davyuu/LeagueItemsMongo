package com.davyuu.leagueappmongo.item;

import android.content.Context;
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

    private RecyclerView itemRecyclerView;
    private ItemAdapter itemAdapter;

    public ItemFragment() {
        // Required empty public constructor
    }

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    private void getData() {
        LeagueApplication.populateAllItems();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        createItemAdapter();
    }

    private void createItemAdapter() {
        itemAdapter = new ItemAdapter(getActivity());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (itemAdapter != null) {
            itemAdapter.onDestroy();
            itemAdapter = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_fragment_layout, container, false);
        itemRecyclerView = (RecyclerView) view.findViewById(R.id.item_recycler_view);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        itemRecyclerView.setAdapter(itemAdapter);
        return view;
    }
}
