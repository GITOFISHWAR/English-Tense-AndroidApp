package com.isk.tense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class PastTenseLane extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pasttenselane);
        MaterialCardView materialTextViewPastSimpleTense = (MaterialCardView) findViewById(R.id.cardpastsimpletense);
        MaterialCardView materialTextViewPastContinuous = (MaterialCardView) findViewById(R.id.cardpastcontinuous);
        MaterialCardView materialTextViewPastPerfect = (MaterialCardView) findViewById(R.id.cardpastperfect);
        MaterialCardView materialTextViewPastPerfectConti = (MaterialCardView) findViewById(R.id.cardpastperfectconti);


        materialTextViewPastSimpleTense.setOnClickListener((i) -> {
            moveToNextdetailedActivity(0);


        });

        materialTextViewPastContinuous.setOnClickListener((i) -> {
            moveToNextdetailedActivity(1);
        });

        materialTextViewPastPerfect.setOnClickListener((i) -> {
            moveToNextdetailedActivity(2);
        });
        materialTextViewPastPerfectConti.setOnClickListener((i) -> {
            moveToNextdetailedActivity(3);
        });

    }

    private void moveToNextdetailedActivity(int i) {
        Intent intent = new Intent(PastTenseLane.this, PastTenseDetail.class);
        intent.putExtra("INDEX", i);
        startActivity(intent);
    }
}
