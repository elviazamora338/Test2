package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Fragments.CreateJournalFragment;
import com.example.myapplication.Fragments.FavoritesFragment;
import com.example.myapplication.Fragments.HomeFragment;
import com.example.myapplication.Fragments.LocationFragment;
import com.example.myapplication.databinding.ActivityMainMenuBinding;

public class MainMenu extends AppCompatActivity {

    ActivityMainMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main_menu);
        setContentView(binding.getRoot());
        Intent mainIntent = getIntent();

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.location:
                    replaceFragment(new LocationFragment());
                    break;
                case R.id.fav:
                    replaceFragment(new FavoritesFragment());
                    break;
                case R.id.create:
                    replaceFragment(new CreateJournalFragment());
                    break;
            }

            return true;
        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }



}