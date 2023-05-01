package com.example.myapplication.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.MyDestinationView.DestinationActivity;
import com.example.myapplication.MyDestinationView.DestinationItem;
import com.example.myapplication.MyDestinationView.DestinationRecyclerViewInterface;
import com.example.myapplication.MyDestinationView.MyDestinationAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements DestinationRecyclerViewInterface {
    ArrayList<DestinationItem> destinationItems = new ArrayList<>();
    int[] destinationImages = {R.drawable.montana, R.drawable.maui, R.drawable.dublin,
            R.drawable.vancouver, R.drawable.orlando, R.drawable.southisland};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.dRecyclerView);
        setUpDestinationItems();

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        MyDestinationAdapter adapter = new MyDestinationAdapter(getContext(),
                destinationItems, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        return view;
    }

    private void setUpDestinationItems() {
        String[] destinationItemNames = getResources().getStringArray(R.array.destination_item_names_txt);
        String[] destinationDesc = getResources().getStringArray(R.array.destination_item_desc_txt);
        String[] destinationCrime = getResources().getStringArray(R.array.destination_item_crime_txt);
        String[] destinationAttract = getResources().getStringArray(R.array.destination_item_attract_txt);
        String[] destinationWeather = getResources().getStringArray(R.array.destination_item_weather_txt);

        for (int i = 0; i < destinationItemNames.length; i++) {
            destinationItems.add(new DestinationItem(destinationItemNames[i], destinationDesc[i],
                    destinationCrime[i], destinationAttract[i], destinationWeather[i],
                    destinationImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), DestinationActivity.class);

        intent.putExtra("NAME", destinationItems.get(position).getDestinationName());
        intent.putExtra("DESCRIPTION", destinationItems.get(position).getDestinationDesc());
        intent.putExtra("CRIME", destinationItems.get(position).getDestinationCrime());
        intent.putExtra("ATTRACTIONS", destinationItems.get(position).getDestinationAttractions());
        intent.putExtra("WEATHER", destinationItems.get(position).getDestinationWeather());
        intent.putExtra("IMAGE", destinationItems.get(position).getDestinationImage());

        startActivity(intent);
    }
}