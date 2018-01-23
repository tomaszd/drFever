package com.example.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import static java.lang.Math.round;

public class CzopekActivity extends AppCompatActivity {
    /**
     * 50 mg, 80 mg, 125 mg, 150 mg, 180 mg, 250 mg, 300 mg
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_czopek);

        Intent myIntent = getIntent();
        final Double amountOfParacetamolMin = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        final Double amountOfParacetamolMax = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);


        final EditText editMin = (EditText) findViewById(R.id.editMin);
        final EditText editMax = (EditText) findViewById(R.id.editMax);

        editMin.setText(String.valueOf(amountOfParacetamolMin));
        editMax.setText(String.valueOf(amountOfParacetamolMax));
        //50
        final EditText min50 = (EditText) findViewById(R.id.editMin50);
        final EditText max50 = (EditText) findViewById(R.id.editMax50);
        min50.setText(getDosageAmount(amountOfParacetamolMin, 50));
        max50.setText(getDosageAmount(amountOfParacetamolMax, 50));
        //80
        final EditText min80 = (EditText) findViewById(R.id.editMin80);
        final EditText max80 = (EditText) findViewById(R.id.editMax80);
        min80.setText(getDosageAmount(amountOfParacetamolMin, 80));
        max80.setText(getDosageAmount(amountOfParacetamolMax, 80));
        //125
        final EditText min125 = (EditText) findViewById(R.id.editMin125);
        final EditText max125 = (EditText) findViewById(R.id.editMax125);
        min125.setText(getDosageAmount(amountOfParacetamolMin, 125));
        max125.setText(getDosageAmount(amountOfParacetamolMax, 125));
        //150
        final EditText min150 = (EditText) findViewById(R.id.editMin150);
        final EditText max150 = (EditText) findViewById(R.id.editMax150);
        min150.setText(getDosageAmount(amountOfParacetamolMin, 150));
        max150.setText(getDosageAmount(amountOfParacetamolMax, 150));
        //180
        final EditText min180 = (EditText) findViewById(R.id.editMin180);
        final EditText max180 = (EditText) findViewById(R.id.editMax180);
        min180.setText(getDosageAmount(amountOfParacetamolMin, 180));
        max180.setText(getDosageAmount(amountOfParacetamolMax, 180));
        //250
        final EditText min250 = (EditText) findViewById(R.id.editMin250);
        final EditText max250 = (EditText) findViewById(R.id.editMax250);
        min250.setText(getDosageAmount(amountOfParacetamolMin, 250));
        max250.setText(getDosageAmount(amountOfParacetamolMax, 250));
        //500
        final EditText min500 = (EditText) findViewById(R.id.editMin500);
        final EditText max500 = (EditText) findViewById(R.id.editMax500);
        min500.setText(getDosageAmount(amountOfParacetamolMin, 500));
        max500.setText(getDosageAmount(amountOfParacetamolMax, 500));
    }

    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return String.valueOf(round(10.0 * amountOfParacetamol / dosageinMl) / 10.0);
    }
}
