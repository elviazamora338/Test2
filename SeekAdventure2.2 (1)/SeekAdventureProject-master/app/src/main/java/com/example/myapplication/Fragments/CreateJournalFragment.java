package com.example.myapplication.Fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.DataClass;
import com.example.myapplication.R;
import com.example.myapplication.UploadActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CreateJournalFragment extends Fragment {
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_journal, container, false);
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(), UploadActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void showFab() {
        fab.show();
    }

    public void hideFab() {
        fab.hide();
    }

}
