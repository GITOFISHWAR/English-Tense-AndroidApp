package com.isk.tense;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PastTenseDetail extends Activity {

    MaterialCardView materialCardView = null;

    MaterialTextView materialTextViewHeading = null;
    MaterialTextView materialTextViewDescription = null;
    MaterialTextView materialTextViewFormulaeValue = null;
    MaterialTextView materialTextViewExampleText1 = null;
    MaterialTextView materialTextViewExampleText2 = null;
    MaterialTextView materialTextViewExampleText3 = null;
    String valueReceived = null;

    static int index = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pastsimpletensedetail);

        materialCardView = findViewById(R.id.cardmv);
        materialCardView.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.red)));
        FloatingActionButton floatingActionButton = findViewById(R.id.fabuttonnext);
        FloatingActionButton floatingActionButtonprevious = findViewById(R.id.fabuttonprev);
        FloatingActionButton floatingActionButtonpractice = findViewById(R.id.fabuttonpractice);
        materialTextViewHeading = findViewById(R.id.textviewHeading);
        materialTextViewDescription = findViewById(R.id.textviewdescription);
        materialTextViewFormulaeValue = findViewById(R.id.textviewformulaeValue);
        materialTextViewExampleText1 = findViewById(R.id.exampletext1);
        materialTextViewExampleText2 = findViewById(R.id.exampletext2);
        materialTextViewExampleText3 = findViewById(R.id.exampletext3);

        //String Past Array from strings.xml
        Map<String, String[]> stringListHashMap = getStringListHashMap();

        //Serial wise keyData
        List<String> listOfkeys = new ArrayList(stringListHashMap.keySet());

        index = getIntent().getIntExtra("INDEX", 0);

        valueReceived = listOfkeys.get(index);
        loadValuesOnView(valueReceived, stringListHashMap);
        floatingActionButton.setOnClickListener((i) ->
        {
            //materialCardView.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.red)));
            if (index < stringListHashMap.size() - 1) {
                index += 1;
            } else {
                index = 0;
                Intent intent = new Intent(PastTenseDetail.this, Practice.class);
                startActivity(intent);

            }
            valueReceived = listOfkeys.get(index);
            loadValuesOnView(valueReceived, stringListHashMap);
        });

        floatingActionButtonprevious.setOnClickListener((i)->{
            if(index!=0) {
                index -= 1;
            }
            valueReceived = listOfkeys.get(index);
            loadValuesOnView(valueReceived, stringListHashMap);
        });

        floatingActionButtonpractice.setOnClickListener((i)->{

            Intent intent = new Intent(PastTenseDetail.this, Practice.class);
            intent.putExtra("TESTFORWHICH", (materialTextViewHeading.getText().toString()).toUpperCase());
            startActivity(intent);
        });
    }

    private Map<String, String[]> getStringListHashMap() {
        Resources resources = getResources();
        //Past
        String[] simplePastTenseArr = resources.getStringArray(R.array.pastsimpledetailsstrarr);
        String[] pastContinuousTenseArr = resources.getStringArray(R.array.pastcontinuousarr);
        String[] pastPerfectTenseArr = resources.getStringArray(R.array.pastperfectarr);
        String[] pastPerfectContitenseArr = resources.getStringArray(R.array.pastperfectcontinuousarr);

        //Present
        String[] simplePresentTenseArr = resources.getStringArray(R.array.simplepresenttensearr);
        String[] presentContinuousTenseArr = resources.getStringArray(R.array.presentcontinuoustensearr);
        String[] presentPerfectTenseArr = resources.getStringArray(R.array.presenperfecttensearr);
        String[] presentPerfectContitenseArr = resources.getStringArray(R.array.presenperfectcontinuoustensearr);

        //Future
        String[] simpleFutureTenseArr = resources.getStringArray(R.array.simplefuturetensearr);
        String[] futureContinuousTenseArr = resources.getStringArray(R.array.futurecontinuoustensearr);
        String[] futurePerfectTenseArr = resources.getStringArray(R.array.futureperfecttensearr);
        String[] futurePerfectContitenseArr = resources.getStringArray(R.array.futureperfectcontinuoustensearr);


        Map<String, String[]> stringListHashMap = new LinkedHashMap<>();
        //past
        stringListHashMap.put("pastsimpletense", simplePastTenseArr);
        stringListHashMap.put("pastcontinuoustense", pastContinuousTenseArr);
        stringListHashMap.put("pastperfecttense", pastPerfectTenseArr);
        stringListHashMap.put("pastperfectcontitense", pastPerfectContitenseArr);
        //present
        stringListHashMap.put("presentsimpletense", simplePresentTenseArr);
        stringListHashMap.put("presentcontinuoustense", presentContinuousTenseArr);
        stringListHashMap.put("presentperfecttense", presentPerfectTenseArr);
        stringListHashMap.put("presentperfectcontitense", presentPerfectContitenseArr);
        //Future
        stringListHashMap.put("futuresimpletense", simpleFutureTenseArr);
        stringListHashMap.put("futurecontinuoustense", futureContinuousTenseArr);
        stringListHashMap.put("futureperfecttense", futurePerfectTenseArr);
        stringListHashMap.put("futureperfectcontitense", futurePerfectContitenseArr);

        return stringListHashMap;
    }

    public void loadValuesOnView(String valueReceived, Map<String, String[]> stringListHashMap) {
        changeMaterialCardColor(valueReceived);
        if (valueReceived != null || stringListHashMap != null) {
            String[] strArr = stringListHashMap.get(valueReceived);
            materialTextViewHeading.setText(strArr[0]);
            materialTextViewDescription.setText(strArr[1]);
            materialTextViewFormulaeValue.setText(strArr[3]);
            materialTextViewExampleText1.setText(strArr[5]);
            materialTextViewExampleText2.setText(strArr[6]);
            materialTextViewExampleText3.setText(strArr[7]);
            // Toast.makeText(getApplicationContext(), strArr[0] + "", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "System received null Hashmap or default value", Toast.LENGTH_LONG).show();
        }
    }

    private void changeMaterialCardColor(String valueReceived) {

        materialCardView.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(), R.color.red)));

    }


}
