package com.isk.tense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.card.MaterialCardView;

public class FutureTenseLane extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.futuretenselane);
        MaterialCardView materialTextViewFutureSimpleTense = (MaterialCardView) findViewById(R.id.card1);
        MaterialCardView materialTextViewFutureContinuous = (MaterialCardView) findViewById(R.id.card3);
        MaterialCardView materialTextViewFuturePerfect = (MaterialCardView) findViewById(R.id.card2);
        MaterialCardView materialTextViewFuturePerfectConti = (MaterialCardView) findViewById(R.id.card4);
        materialTextViewFutureSimpleTense.setOnClickListener((i) -> {
            moveToNextdetailedActivity(8);
        });

        materialTextViewFutureContinuous.setOnClickListener((i) -> {
            moveToNextdetailedActivity(9);
        });

        materialTextViewFuturePerfect.setOnClickListener((i) -> {
            moveToNextdetailedActivity(10);
        });

        materialTextViewFuturePerfectConti.setOnClickListener((i) -> {
            moveToNextdetailedActivity(11);
        });

    }

    private void moveToNextdetailedActivity(int i) {
        Intent intent = new Intent(FutureTenseLane.this, PastTenseDetail.class);
        intent.putExtra("INDEX", i);
        startActivity(intent);
    }
}
