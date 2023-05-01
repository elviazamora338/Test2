package com.example.myapplication.MyDestinationView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        String crime = getIntent().getStringExtra("CRIME");
        String attractions = getIntent().getStringExtra("ATTRACTIONS");
        String weather = getIntent().getStringExtra("WEATHER");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView nameTV = findViewById(R.id.nameTV);
        TextView descTV = findViewById(R.id.descTV);
        TextView crimeTV = findViewById(R.id.crimeTV);
        TextView attractTV = findViewById(R.id.attractTV);
        TextView weatherTV = findViewById(R.id.weatherTV);
        ImageView dImage = findViewById(R.id.dImage);

        nameTV.setText(name);
        descTV.setText(description);
        crimeTV.setText(crime);
        attractTV.setText(attractions);
        weatherTV.setText(weather);
        dImage.setImageResource(image);
    }



}
