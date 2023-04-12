package com.example.myapplication.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Adapters.DestinationAdapter;
import com.example.myapplication.Helpers.DestinationItem;
import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<DestinationItem> destinationItems = new ArrayList<>();

    public View onCreate(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DestinationAdapter(destinationItems, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        destinationItems.add(new DestinationItem(R.drawable.maui, "Maui", "0", "0"));
        destinationItems.add(new DestinationItem(R.drawable.southisland, "South Island", "1", "0"));
        destinationItems.add(new DestinationItem(R.drawable.vancouver, "Vancouver", "2", "0"));
        destinationItems.add(new DestinationItem(R.drawable.orlando, "Orlando", "3", "0"));
        destinationItems.add(new DestinationItem(R.drawable.dublin, "Dublin", "4", "0"));

        return root;

    }


}