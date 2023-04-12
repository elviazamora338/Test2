package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getStarted = findViewById(R.id.getStarted);

        Intent secondIntent = new Intent(this, MainMenu.class);

        getStarted.setOnClickListener(v ->
        {
            startActivity(secondIntent);
        });

    }
}