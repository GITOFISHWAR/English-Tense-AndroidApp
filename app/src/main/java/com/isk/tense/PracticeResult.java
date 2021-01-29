package com.isk.tense;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PracticeResult extends AppCompatActivity {

    AppCompatImageView appCompatImageView = null;
    AppCompatTextView appCompatTextView = null;
    FloatingActionButton floatingActionButtonHome = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practiceresult);
        appCompatImageView = findViewById(R.id.imageview);
        appCompatTextView = (AppCompatTextView) findViewById(R.id.tvresult);
        floatingActionButtonHome = findViewById(R.id.fabuttonhome);
        int resultStr = getIntent().getIntExtra("RESULT", 1);
        if (resultStr >= 70) {
            appCompatImageView.setImageURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.goodjob));
            appCompatTextView.setText(Integer.toString(resultStr) + "%");
        } else if (resultStr == 60) {
            appCompatImageView.setImageURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.keepup));
            appCompatTextView.setText(Integer.toString(resultStr) + "%");
        } else {
            appCompatImageView.setImageURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.failed));
            appCompatTextView.setText(Integer.toString(resultStr) + "%");
        }
        floatingActionButtonHome.setOnClickListener((i) -> {

            Intent intent = new Intent(PracticeResult.this, Home.class);
            startActivity(intent);

        });
    }
}
