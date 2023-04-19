package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button getStarted = findViewById(R.id.getStarted);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
//                startActivity(intent);
//            }
//        });

        Intent secondIntent = new Intent(this, MainMenu.class);

        getStarted.setOnClickListener(v ->
        {
            startActivity(secondIntent);
        });

    }

}