package com.isk.tense;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.card.MaterialCardView;

public class Home extends AppCompatActivity {

    AdView adView = null;
    MaterialCardView materialCardViewads = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        MaterialCardView materialCardView = (MaterialCardView) findViewById(R.id.card1);
        MaterialCardView materialCardViewpresent = (MaterialCardView) findViewById(R.id.card2);
        MaterialCardView materialCardViewfuture = (MaterialCardView) findViewById(R.id.card3);
        MaterialCardView materialCardPractice= (MaterialCardView) findViewById(R.id.cardpractice);
        materialCardViewads = findViewById(R.id.cardads);
       // materialCardViewads.setVisibility(View.INVISIBLE);
        //Ads
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                System.out.println("YAHOOOO!"+loadAdError.getMessage());
                Toast.makeText(getApplicationContext(), "onAdFailedToLoad", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                materialCardViewads.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "onAdLoaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                Toast.makeText(getApplicationContext(), "onAdClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
                Toast.makeText(getApplicationContext(), "onAdImpression", Toast.LENGTH_SHORT).show();
            }
        });
        //Ads-End


        materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,PastTenseLane.class);
                startActivity(intent);
            }
        });

        materialCardViewpresent.setOnClickListener((i) -> {
            Intent intent = new Intent(Home.this, PresentTenseLane.class);
            startActivity(intent);
        });

        materialCardViewfuture.setOnClickListener((i) -> {
            Intent intent = new Intent(Home.this, FutureTenseLane.class);
            startActivity(intent);
        });

        materialCardPractice.setOnClickListener((i)->{

            Intent intent = new Intent(Home.this, Practice.class);
            intent.putExtra("TESTFORWHICH", "");
            startActivity(intent);
        });
    }

}
