package com.example.tomaszd.drfever;

import android.content.Intent;
import android.graphics.Color;
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
        final EditText max50Podac = (EditText) findViewById(R.id.editMax50Podac);
        if (amountOfParacetamolMin <= 50 && 50 <= amountOfParacetamolMax) {
            max50Podac.setText("Podac");
            max50Podac.setTextColor(Color.GREEN);
        } else {
            max50Podac.setText("Nie Podawac");
            max50Podac.setTextColor(Color.RED);
        }

        //80
        final EditText min80 = (EditText) findViewById(R.id.editMin80);
        final EditText max80 = (EditText) findViewById(R.id.editMax80);
        final EditText max80Podac = (EditText) findViewById(R.id.editMax80Podac);
        min80.setText(getDosageAmount(amountOfParacetamolMin, 80));
        max80.setText(getDosageAmount(amountOfParacetamolMax, 80));
        if (amountOfParacetamolMin <= 80 && 80 <= amountOfParacetamolMax) {
            max80Podac.setText("Podac");
            max80Podac.setTextColor(Color.GREEN);
        } else {
            max80Podac.setText("Nie Podawac");
            max80Podac.setTextColor(Color.RED);
        }
        //125
        final EditText min125 = (EditText) findViewById(R.id.editMin125);
        final EditText max125 = (EditText) findViewById(R.id.editMax125);
        min125.setText(getDosageAmount(amountOfParacetamolMin, 125));
        max125.setText(getDosageAmount(amountOfParacetamolMax, 125));
        final EditText max125Podac = (EditText) findViewById(R.id.editMax125Podac);
        if (amountOfParacetamolMin <= 125 && 125 <= amountOfParacetamolMax) {
            max125Podac.setText("Podac");
            max125Podac.setTextColor(Color.GREEN);
        } else {
            max125Podac.setText("Nie Podawac");
            max125Podac.setTextColor(Color.RED);
        }
        //150
        final EditText min150 = (EditText) findViewById(R.id.editMin150);
        final EditText max150 = (EditText) findViewById(R.id.editMax150);
        min150.setText(getDosageAmount(amountOfParacetamolMin, 150));
        max150.setText(getDosageAmount(amountOfParacetamolMax, 150));
        final EditText max150Podac = (EditText) findViewById(R.id.editMax150Podac);
        if (amountOfParacetamolMin <= 150 && 150 <= amountOfParacetamolMax) {
            max150Podac.setText("Podac");
            max150Podac.setTextColor(Color.GREEN);
        } else {
            max150Podac.setText("Nie Podawac");
            max150Podac.setTextColor(Color.RED);
        }
        //180
        final EditText min180 = (EditText) findViewById(R.id.editMin180);
        final EditText max180 = (EditText) findViewById(R.id.editMax180);
        min180.setText(getDosageAmount(amountOfParacetamolMin, 180));
        max180.setText(getDosageAmount(amountOfParacetamolMax, 180));
        final EditText max180Podac = (EditText) findViewById(R.id.editMax180Podac);
        if (amountOfParacetamolMin <= 180 && 180 <= amountOfParacetamolMax) {
            max180Podac.setText("Podac");
            max180Podac.setTextColor(Color.GREEN);
        } else {
            max180Podac.setText("Nie Podawac");
            max180Podac.setTextColor(Color.RED);
        }
        //250
        final EditText min250 = (EditText) findViewById(R.id.editMin250);
        final EditText max250 = (EditText) findViewById(R.id.editMax250);
        min250.setText(getDosageAmount(amountOfParacetamolMin, 250));
        max250.setText(getDosageAmount(amountOfParacetamolMax, 250));
        final EditText max250Podac = (EditText) findViewById(R.id.editMax50Podac);
        if (amountOfParacetamolMin <= 250 && 250 <= amountOfParacetamolMax) {
            max250Podac.setText("Podac");
            max250Podac.setTextColor(Color.GREEN);
        } else {
            max250Podac.setText("Nie Podawac");
            max250Podac.setTextColor(Color.RED);
        }
        //500
        final EditText min500 = (EditText) findViewById(R.id.editMin500);
        final EditText max500 = (EditText) findViewById(R.id.editMax500);
        min500.setText(getDosageAmount(amountOfParacetamolMin, 500));
        max500.setText(getDosageAmount(amountOfParacetamolMax, 500));
        final EditText max500Podac = (EditText) findViewById(R.id.editMax50Podac);
        if (amountOfParacetamolMin <= 500 && 500 <= amountOfParacetamolMax) {
            max500Podac.setText("Podac");
            max500Podac.setTextColor(Color.GREEN);
        } else {
            max500Podac.setText("Nie Podawac");
            max500Podac.setTextColor(Color.RED);
        }
    }

    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return String.valueOf(round(10.0 * amountOfParacetamol / dosageinMl) / 10.0);
    }
}
