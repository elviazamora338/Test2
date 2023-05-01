package com.example.myapplication.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.DisplayFavorites.FavDestinationAdapter;
import com.example.myapplication.DisplayFavorites.FavDestinationItem;
import com.example.myapplication.R;

import java.util.ArrayList;


public class FavoritesFragment extends Fragment {

    private ArrayList<FavDestinationItem> favDestinationItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

//        RecyclerView recyclerView = view.findViewById(R.id.favRecyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(new FavDestinationAdapter(favDestinationItems, getActivity()));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        favDestinationItems.add(new FavDestinationItem(R.drawable.montana, "Glacier National Park, Montana", "0", "0"));
//        favDestinationItems.add(new FavDestinationItem(R.drawable.maui, "Maui, Hawaii", "1", "0"));
//        favDestinationItems.add(new FavDestinationItem(R.drawable.dublin, "Dublin, Ireland", "2", "0"));
//        favDestinationItems.add(new FavDestinationItem(R.drawable.vancouver, "Vancouver, Canada", "3", "0"));
//        favDestinationItems.add(new FavDestinationItem(R.drawable.orlando, "Orlando, Florida", "4", "0"));
//        favDestinationItems.add(new FavDestinationItem(R.drawable.southisland, "South Island, New Zealand", "5", "0"));


        return view;
    }
}