package com.example.assignment3.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment3.FavouriteAdapter;
import com.example.assignment3.R;
import com.example.assignment3.activities.MainActivity;

public class FavouriteFragment extends Fragment {
    private RecyclerView recyclerView;

    public FavouriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        recyclerView = view.findViewById(R.id.rv_main1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        FavouriteAdapter favouriteAdapter = new FavouriteAdapter();
        recyclerView.setAdapter(favouriteAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity parent = (MainActivity) getActivity();
        parent.showCoolMessage(" Here is your Favourite Cat List !!! ");
    }

}
