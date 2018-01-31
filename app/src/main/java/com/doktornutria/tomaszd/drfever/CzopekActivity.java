package com.doktornutria.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import static java.lang.Math.round;

public class CzopekActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_czopek);
        //Dostępne czopki z paracetamolem: 500, 300, 250, 180, 150, 125, 80, 50

        final Button buttonParacetamolDosageAmount = (Button) findViewById(R.id.buttonParacetamolDosageAmount);
        final Button buttonParacetamolDosageCzopekAmount = (Button) findViewById(R.id.buttonParacetamolDosageCzopekAmount);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Intent myIntent = getIntent();
        //final Double amountOfParacetamolMin = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        final Double amountOfParacetamolMax = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);
        buttonParacetamolDosageAmount.setText(String.valueOf("        " + String.valueOf(amountOfParacetamolMax) + " mg"));
        buttonParacetamolDosageCzopekAmount.setText("         Wybierz czopek");

        final Button button_Czopek_parac_500 = (Button) findViewById(R.id.button_Czopek_parac_500);
        final Button button_Czopek_parac_300 = (Button) findViewById(R.id.button_Czopek_parac_300);
        final Button button_Czopek_parac_250 = (Button) findViewById(R.id.button_Czopek_parac_250);
        final Button button_Czopek_parac_180 = (Button) findViewById(R.id.button_Czopek_parac_180);
        final Button button_Czopek_parac_150 = (Button) findViewById(R.id.button_Czopek_parac_150);
        final Button button_Czopek_parac_125 = (Button) findViewById(R.id.button_Czopek_parac_125);
        final Button button_Czopek_parac_80 = (Button) findViewById(R.id.button_Czopek_parac_80);
        final Button button_Czopek_parac_50 = (Button) findViewById(R.id.button_Czopek_parac_50);

        button_Czopek_parac_500.setAnimation(shakeButtonAnimation);
        button_Czopek_parac_300.setAnimation(shakeButtonAnimation);
        button_Czopek_parac_250.setAnimation(shakeButtonAnimation);
        button_Czopek_parac_180.setAnimation(shakeButtonAnimation);
        button_Czopek_parac_150.setAnimation(shakeButtonAnimation);
        button_Czopek_parac_125.setAnimation(shakeButtonAnimation);
        button_Czopek_parac_80.setAnimation(shakeButtonAnimation);
        button_Czopek_parac_50.setAnimation(shakeButtonAnimation);


        button_Czopek_parac_500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 500));
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                button_Czopek_parac_500.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        button_Czopek_parac_300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 300));
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                button_Czopek_parac_300.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        button_Czopek_parac_250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 250));
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                button_Czopek_parac_250.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        button_Czopek_parac_180.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 180));
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                button_Czopek_parac_180.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });
        button_Czopek_parac_150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 150));
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                button_Czopek_parac_150.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });
        button_Czopek_parac_125.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 125));
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                button_Czopek_parac_125.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);
            }
        });
        button_Czopek_parac_80.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 80));
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                button_Czopek_parac_80.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);
            }
        });
        button_Czopek_parac_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageCzopekAmount.setText(getDosageAmount(amountOfParacetamolMax, 50));

                button_Czopek_parac_50.setAnimation(shakeButtonAnimation);
                buttonParacetamolDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);
            }
        });


    }


    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return "          " + String.valueOf(round((dosageinMl / amountOfParacetamol) * 100)) + "% dawki";
    }
}
