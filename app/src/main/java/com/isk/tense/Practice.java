package com.isk.tense;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Practice extends AppCompatActivity {

    MaterialTextView materialTextViewQuestion = null;
    MaterialTextView materialTextViewOption1 = null;
    MaterialTextView materialTextViewOption2 = null;
    MaterialTextView materialTextViewOption3 = null;
    MaterialTextView materialTextViewOption4 = null;

    MaterialCardView materialCardViewOption1 = null;
    MaterialCardView materialCardViewOption2 = null;
    MaterialCardView materialCardViewOption3 = null;
    MaterialCardView materialCardViewOption4 = null;
    List<String> randomQuestionList = null;
    AtomicInteger count = null;
    List<String> optionArrayList = null;
    List<Integer> randomOptionList = null;
    int resultCounter = 0;
    List<String> quesAndOptionsList = new ArrayList<>();
    String practiceFor = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice);
        initialize();
        practiceFor = getIntent().getStringExtra("TESTFORWHICH");
        randomQuestionList = createTest(practiceFor.trim());
        count = new AtomicInteger(0);
        //Load Default Values
        quesAndOptionsList = getValuesFromData(randomQuestionList, count);
        materialTextViewQuestion.setText(quesAndOptionsList.get(4));
        materialTextViewOption1.setText(quesAndOptionsList.get(1));
        materialTextViewOption2.setText(quesAndOptionsList.get(2));
        materialTextViewOption3.setText(quesAndOptionsList.get(3));
        materialTextViewOption4.setText(quesAndOptionsList.get(0));
        //LDV

        materialCardViewOption1.setOnClickListener((i) -> {
            if (((count.intValue()) < 10)) {
                String correctAnswer = getCorrectAnswerForTheGivenQuestion();
                String selectedAnswer = ((materialTextViewOption1.getText()).toString()).trim();
                resultCounter = makeDecision(correctAnswer, selectedAnswer, resultCounter);
                quesAndOptionsList = getValuesFromData(randomQuestionList, count);
                materialTextViewQuestion.setText(quesAndOptionsList.get(4));
                materialTextViewOption1.setText(quesAndOptionsList.get(1));
                materialTextViewOption2.setText(quesAndOptionsList.get(2));
                materialTextViewOption3.setText(quesAndOptionsList.get(3));
                materialTextViewOption4.setText(quesAndOptionsList.get(0));

            } else {
                moveToNextActivity(resultCounter);
            }

        });

        materialCardViewOption2.setOnClickListener((i) -> {
            if (((count.intValue()) < 10)) {
                String correctAnswer = getCorrectAnswerForTheGivenQuestion();
                String selectedAnswer = ((materialTextViewOption2.getText()).toString()).trim();
                resultCounter = makeDecision(correctAnswer, selectedAnswer, resultCounter);

                quesAndOptionsList = getValuesFromData(randomQuestionList, count);
                materialTextViewQuestion.setText(quesAndOptionsList.get(4));
                materialTextViewOption1.setText(quesAndOptionsList.get(1));
                materialTextViewOption2.setText(quesAndOptionsList.get(2));
                materialTextViewOption3.setText(quesAndOptionsList.get(3));
                materialTextViewOption4.setText(quesAndOptionsList.get(0));

            } else {
                moveToNextActivity(resultCounter);

            }
        });

        materialCardViewOption3.setOnClickListener((i) -> {
            if (((count.intValue()) < 10)) {
                String correctAnswer = getCorrectAnswerForTheGivenQuestion();
                String selectedAnswer = ((materialTextViewOption3.getText()).toString()).trim();
                resultCounter = makeDecision(correctAnswer, selectedAnswer, resultCounter);

                quesAndOptionsList = getValuesFromData(randomQuestionList, count);
                materialTextViewQuestion.setText(quesAndOptionsList.get(4));

                materialTextViewOption1.setText(quesAndOptionsList.get(1));
                materialTextViewOption2.setText(quesAndOptionsList.get(2));
                materialTextViewOption3.setText(quesAndOptionsList.get(3));
                materialTextViewOption4.setText(quesAndOptionsList.get(0));

            } else {
                moveToNextActivity(resultCounter);

            }
        });

        materialCardViewOption4.setOnClickListener((i) -> {
            if (((count.intValue()) < 10)) {
                String correctAnswer = getCorrectAnswerForTheGivenQuestion();
                String selectedAnswer = ((materialTextViewOption4.getText()).toString()).trim();
                resultCounter = makeDecision(correctAnswer, selectedAnswer, resultCounter);

                quesAndOptionsList = getValuesFromData(randomQuestionList, count);
                materialTextViewQuestion.setText(quesAndOptionsList.get(4));

                materialTextViewOption1.setText(quesAndOptionsList.get(1));
                materialTextViewOption2.setText(quesAndOptionsList.get(2));
                materialTextViewOption3.setText(quesAndOptionsList.get(3));
                materialTextViewOption4.setText(quesAndOptionsList.get(0));
            } else {
                moveToNextActivity(resultCounter);

            }
        });
    }

    private void moveToNextActivity(int resultCounter) {
      //  Toast.makeText(getApplicationContext(), "" + resultCounter, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(Practice.this, PracticeResult.class);
        int result = (resultCounter * 100) / 10;
        intent.putExtra("RESULT", (result));
        startActivity(intent);
    }

    private int makeDecision(String correctAnswer, String selectedAnswer, int resultCounter) {
        if (correctAnswer.equals(selectedAnswer)) {
            return resultCounter + 1;
        }
        return resultCounter;
    }

    private String getCorrectAnswerForTheGivenQuestion() {
        String[] quesNans = filterQuestion(randomQuestionList.get((count.intValue()) - 1)); // correct is prev answer
        return (((quesNans[1]).toUpperCase()).trim());
    }

    private void initialize() {

        materialTextViewQuestion = findViewById(R.id.tvques);
        materialTextViewOption1 = findViewById(R.id.tvoption1);
        materialTextViewOption2 = findViewById(R.id.tvoption2);
        materialTextViewOption3 = findViewById(R.id.tvoption3);
        materialTextViewOption4 = findViewById(R.id.tvoption4);

        materialCardViewOption1 = findViewById(R.id.cardoption1);
        materialCardViewOption2 = findViewById(R.id.cardoption2);
        materialCardViewOption3 = findViewById(R.id.cardoption3);
        materialCardViewOption4 = findViewById(R.id.cardoption4);

    }

    private List<String> getValuesFromData(List<String> randomQuestionList, AtomicInteger count) {

        List<String> finalList = new ArrayList<>();
        String[] quesAndans = filterQuestion(randomQuestionList.get(count.intValue()));
        String[] optionArray = getResources().getStringArray(R.array.optionarray);
        optionArrayList = Arrays.asList(optionArray);
        //3 options
        randomOptionList = generateRandomNumberList(optionArrayList.size());

        for (int i = 0; i < 3; i++) {
            finalList.add(i, (optionArrayList.get(randomOptionList.get(i))).toUpperCase());
        }
        finalList.add(3, ((quesAndans[1]).toUpperCase()).trim()); // add correct answer
        // Validate if contains correct answer
        finalList = validationOfFinalOptionList(finalList, (quesAndans[1].toUpperCase().trim()));
        finalList.add(4, quesAndans[0]); // add ques after shuffling
        count.addAndGet(1);
        return finalList;
    }

    //Review Pending
    private List<String> validationOfFinalOptionList(List<String> finalList, String quesAndans) {
        Random random = new Random();
        Collections.replaceAll(finalList, quesAndans, optionArrayList.get(random.nextInt(12)));
    /*   if (finalList.contains(quesAndans.trim())) {
            //Leaving for future changes if required
        }*/
        Collections.shuffle(finalList);
        return finalList;
    }

    private String[] filterQuestion(String s) {

        String[] arrValue = s.split("\\|");
        return arrValue;
    }

    private List<String> createTest(String practiceFor) {

        Resources resources = getResources();
        List<String> testData = new ArrayList<>();
        String[] quesAndAnsData = resources.getStringArray(R.array.practiceData);
        List<String> quesAndAnsDataList = Arrays.asList(quesAndAnsData);

        if (practiceFor.equalsIgnoreCase("")) {
            List<Integer> listOfNumbers = generateRandomNumberList(quesAndAnsData.length);
            int i = 0;
            while (i < listOfNumbers.size()) {
                testData.add(quesAndAnsDataList.get(listOfNumbers.get(i)));
                i++;
            }
        } else {
            List<String> practiceForList = new ArrayList<>();
            String[] str = new String[2];
            for (int i = 0; i < quesAndAnsDataList.size(); i++) {
                str = filterQuestion(quesAndAnsDataList.get(i));
                if ((str[1].trim().toUpperCase()).equalsIgnoreCase(practiceFor)) {
                    practiceForList.add(quesAndAnsDataList.get(i));
                }
            }
           List<Integer> listOfNumbers = generateRandomNumberList(practiceForList.size());

            int i = 0;
            while (i < listOfNumbers.size()) {
                testData.add(practiceForList.get(listOfNumbers.get(i)));
                i++;
            }
        }
        return testData;

    }

    private List<Integer> generateRandomNumberList(int quesAndAnsData) {
        List<Integer> listOfNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            listOfNumbers.add(random.nextInt(quesAndAnsData));
        }
        return listOfNumbers;
    }

}
