package com.example.myapplication.MyJournalView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.Fragments.CreateJournalFragment;
import com.example.myapplication.MainMenu;
import com.example.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class UpdateActivity extends AppCompatActivity {

    ImageView updateImage;
    Button updateButton;
    EditText updateTitle, updateFacts, updateMoments, updateActivities, updateDate, updateLocation;
    String title, facts, moments, activities, date, location;
    String imageURL;
    String key, oldImageURL;
    Uri uri;
    DatabaseReference databaseReference;
    StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        updateButton = findViewById(R.id.updateButton);
        updateTitle = findViewById(R.id.updateTitle);
        updateFacts = findViewById(R.id.updateFacts);
        updateMoments = findViewById(R.id.updateMoments);
        updateActivities = findViewById(R.id.updateActivities);
        updateDate = findViewById(R.id.updateDate);
        updateLocation = findViewById(R.id.updateLocation);

        ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>(){
                    @Override
                    public void onActivityResult(ActivityResult result){
                        if(result.getResultCode() == Activity.RESULT_OK){
                            Intent data = result.getData();
                            uri = data.getData();
                            updateImage.setImageURI(uri);
                        }
                        else{
                            Toast.makeText(UpdateActivity.this,"No Image Selected", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            Glide.with(UpdateActivity.this).load(bundle.getString("Image")).into(updateImage);
            updateTitle.setText(bundle.getString("Title"));
            updateDate.setText(bundle.getString("Date"));
            updateLocation.setText(bundle.getString("Location"));
            updateFacts.setText(bundle.getString("Facts"));
            updateMoments.setText(bundle.getString("Moments"));
            updateActivities.setText(bundle.getString("Activities"));
            key = bundle.getString("Key");
            oldImageURL = bundle.getString("Image");

        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Seek Adventures").child(key);

        updateImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent photoPicker = new Intent(Intent.ACTION_PICK);
                photoPicker.setType("image/*");
                activityResultLauncher.launch(photoPicker);
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveData();
                Intent intent = new Intent(UpdateActivity.this, CreateJournalFragment.class);
                startActivity(intent);
            }
        });
    }
    public void saveData(){
        storageReference = FirebaseStorage.getInstance().getReference().child("Android Images").child(uri.getLastPathSegment());

        AlertDialog.Builder builder = new AlertDialog.Builder(UpdateActivity.this);
        builder.setCancelable(false);
        builder.setView(R.layout.progress_layout);
        AlertDialog dialog = builder.create();
        dialog.show();

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot){
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageURL = urlImage.toString();

                updateData();
                dialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e){
                dialog.dismiss();
            }
        });
    }
    public void updateData(){
        String title = updateTitle.getText().toString().trim();
        String date = updateDate.getText().toString().trim();
        String location = updateLocation.getText().toString().trim();
        String facts = updateFacts.getText().toString().trim();
        String moments = updateMoments.getText().toString().trim();
        String activities = updateActivities.getText().toString().trim();

        DataClass dataClass = new DataClass(title, date, location, facts, moments, activities, imageURL);

        databaseReference.setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>(){
            @Override
            public void onComplete(@NonNull Task<Void> task){
                if(task.isSuccessful()){
                    StorageReference reference = FirebaseStorage.getInstance().getReferenceFromUrl(oldImageURL);
                    reference.delete();
                    Toast.makeText(UpdateActivity.this,"Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e){
                Toast.makeText(UpdateActivity.this, e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

