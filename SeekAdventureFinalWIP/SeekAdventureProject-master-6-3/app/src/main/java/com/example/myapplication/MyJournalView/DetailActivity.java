package com.example.myapplication.MyJournalView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.myapplication.Fragments.CreateJournalFragment;
import com.example.myapplication.R;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

// DetailActivity class displays details of a journal entry and allows the user to delete it
// This corresponds to the activity_detail.xml
public class DetailActivity extends AppCompatActivity {

    // Declare the instance variables used in the class
    TextView detailDate, detailTitle, detailMoments, detailFacts, detailActivities, detailLocation;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";


    // TextView and ImageView are initialized in the onCreate() method
    // using the findViewById() method
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
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);



        // Bundle object received from the previous activity is used to retrieve the details
        // of the journal entry and set the values of the view elements
        Bundle bundle = getIntent().getExtras();
        // Checks if the data is properly initialized
        if (bundle != null) {
            // retrieves the value associated with the key in the Bundle object
            // and sets it as their respective elements
            detailMoments.setText(bundle.getString("Moments"));
            detailDate.setText(bundle.getString("Date"));
            detailTitle.setText(bundle.getString("Title"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
            detailFacts.setText(bundle.getString("Facts"));
            detailActivities.setText(bundle.getString("Activities"));
            detailLocation.setText(bundle.getString("Location"));
        }
            // A floating action button is assigned a click listener which deletes the journal entry and
            // corresponding images from the Firebase database

            // A message is displayed using toast that says 'Deleted' and the user is
            // redirected to the 'Create Journal Fragment' activity
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Seek Adventure");
                    FirebaseStorage storage = FirebaseStorage.getInstance();

                    StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                    storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            reference.child(key).removeValue();
                            Toast.makeText(DetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), CreateJournalFragment.class));
                            finish();
                        }
                    });
                }
            });

            editButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(DetailActivity.this,UpdateActivity.class)
                            .putExtra("Image",imageUrl)
                            .putExtra("Title",detailTitle.getText().toString())
                            .putExtra("Location",detailLocation.getText().toString())
                            .putExtra("Date", detailDate.getText().toString())
                            .putExtra("Moments",detailMoments.getText().toString())
                            .putExtra("Facts",detailFacts.getText().toString())
                            .putExtra("Activities",detailActivities.getText().toString())
                            .putExtra("Key", key);
                    startActivity(intent);
                }
            });
        }
    }
