package com.example.myapplication;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.example.myapplication.UploadActivity;
import android.view.LayoutInflater;
import com.example.myapplication.R;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;

public class FabButton {
    public static void init(AppCompatActivity activity){
        View root = root.getWindow().getDecorView();
        FloatingActionButton fab = new FloatingActionButton(getContext());
        fab.setId(R.id.fab);
        fab.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        ));
        root.addView(fab);
    }
}
