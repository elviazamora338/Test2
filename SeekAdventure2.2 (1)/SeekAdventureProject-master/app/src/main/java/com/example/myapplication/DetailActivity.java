package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView detailTitle, detailMoments,detailFacts, detailActivities;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);
        detailFacts = findViewById(R.id.detailFacts);
        detailMoments = findViewById(R.id.detailMoments);
        detailActivities = findViewById(R.id.detailActivities);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailMoments.setText(bundle.getString("Moments"));
            detailTitle.setText(bundle.getString("Title"));
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
    }
}