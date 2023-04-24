package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView detailDate, detailTitle, detailMoments, detailFacts, detailActivities, detailLocation;
    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle = findViewById(R.id.detailTitle);
        detailDate = findViewById(R.id.detailDate);
        detailImage = findViewById(R.id.detailImage);
        detailFacts = findViewById(R.id.detailFacts);
        detailMoments = findViewById(R.id.detailMoments);
        detailActivities = findViewById(R.id.detailActivities);
        detailLocation = findViewById(R.id.detailLocation);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            detailMoments.setText(bundle.getString("Moments"));
            detailDate.setText(bundle.getString("Date"));
            detailTitle.setText(bundle.getString("Title"));
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
            detailFacts.setText(bundle.getString("Facts"));
            detailActivities.setText(bundle.getString("Activities"));
            detailLocation.setText(bundle.getString("Location"));
        }
    }
}