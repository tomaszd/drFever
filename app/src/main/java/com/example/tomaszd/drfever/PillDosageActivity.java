package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import static java.lang.Math.round;

public class PillDosageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_dosage);

        Intent myIntent = getIntent();
        final Double amountOfParacetamolMin = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        final Double amountOfParacetamolMax = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);

        //500 mg tabletce, oraz 250 mg (saszetki), 300 mg, i 1 g

        //1000
        final EditText min1000 = (EditText) findViewById(R.id.editMin1000);
        final EditText max1000 = (EditText) findViewById(R.id.editMax1000);
        min1000.setText(getDosageAmount(amountOfParacetamolMin, 1000));
        max1000.setText(getDosageAmount(amountOfParacetamolMax, 1000));

        //500
        final EditText min500 = (EditText) findViewById(R.id.editMin500);
        final EditText max500 = (EditText) findViewById(R.id.editMax500);
        min500.setText(getDosageAmount(amountOfParacetamolMin, 500));
        max500.setText(getDosageAmount(amountOfParacetamolMax, 500));

        //300
        final EditText min300 = (EditText) findViewById(R.id.editMin300);
        final EditText max300 = (EditText) findViewById(R.id.editMax300);
        min300.setText(getDosageAmount(amountOfParacetamolMin, 300));
        max300.setText(getDosageAmount(amountOfParacetamolMax, 300));

        //250
        final EditText min250 = (EditText) findViewById(R.id.editMin250);
        final EditText max250 = (EditText) findViewById(R.id.editMax250);
        min250.setText(getDosageAmount(amountOfParacetamolMin, 250));
        max250.setText(getDosageAmount(amountOfParacetamolMax, 250));

    }

    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return String.valueOf(round(10.0 * amountOfParacetamol / dosageinMl) / 10.0);
    }
}
