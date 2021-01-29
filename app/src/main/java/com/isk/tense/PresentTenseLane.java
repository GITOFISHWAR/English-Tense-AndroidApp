package com.isk.tense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.card.MaterialCardView;

public class PresentTenseLane extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presenttenselane);
        MaterialCardView materialTextViewPresentSimpleTense = (MaterialCardView) findViewById(R.id.card1);
        MaterialCardView materialTextViewPresentContinuous = (MaterialCardView) findViewById(R.id.card3);
        MaterialCardView materialTextViewPresentPerfect = (MaterialCardView) findViewById(R.id.card2);
        MaterialCardView materialTextViewPresentPerfectConti = (MaterialCardView) findViewById(R.id.card4);

        materialTextViewPresentSimpleTense.setOnClickListener((i) -> {
           moveToNextdetailedActivity(4);
        });

        materialTextViewPresentContinuous.setOnClickListener((i) -> {
            moveToNextdetailedActivity(5);
        });

        materialTextViewPresentPerfect.setOnClickListener((i) -> {
            moveToNextdetailedActivity(6);
        });

        materialTextViewPresentPerfectConti.setOnClickListener((i) -> {
            moveToNextdetailedActivity(7);
        });

    }

    private void moveToNextdetailedActivity(int i) {
        Intent intent = new Intent(PresentTenseLane.this, PastTenseDetail.class);
        intent.putExtra("INDEX", i);
        startActivity(intent);
    }
}
