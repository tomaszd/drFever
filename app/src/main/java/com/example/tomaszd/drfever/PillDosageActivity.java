package com.example.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import static java.lang.Math.round;

public class PillDosageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_dosage);
        //Paracetamol występuje w najczęstszej 500 mg tabletce, oraz 250 mg (saszetki), 300 mg, i 1 g.

        final Button buttonParacetamolDosageAmount = (Button) findViewById(R.id.buttonParacetamolDosageAmount);
        final Button buttonParacetamolDosagePillAmount = (Button) findViewById(R.id.buttonParacetamolDosagepillAmount);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Intent myIntent = getIntent();
        //final Double amountOfParacetamolMin = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        final Double amountOfParacetamolMax = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);
        buttonParacetamolDosageAmount.setText(String.valueOf("        " + String.valueOf(amountOfParacetamolMax) + " mg"));
        buttonParacetamolDosagePillAmount.setText("Tabletka");

        final Button button_pill_parac_1000 = (Button) findViewById(R.id.button_pill_parac_1000);
        final Button button_pill_parac_500 = (Button) findViewById(R.id.button_pill_parac_500);
        final Button button_pill_parac_300 = (Button) findViewById(R.id.button_pill_parac_300);
        final Button button_pill_parac_250 = (Button) findViewById(R.id.button_pill_parac_250);


        button_pill_parac_1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosagePillAmount.setText(getDosageAmount(amountOfParacetamolMax, 1000));

                buttonParacetamolDosagePillAmount.setAnimation(shakeButtonAnimation);
                button_pill_parac_1000.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        button_pill_parac_500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosagePillAmount.setText(getDosageAmount(amountOfParacetamolMax, 500));

                buttonParacetamolDosagePillAmount.setAnimation(shakeButtonAnimation);
                button_pill_parac_500.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });
        button_pill_parac_300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosagePillAmount.setText(getDosageAmount(amountOfParacetamolMax, 300));

                buttonParacetamolDosagePillAmount.setAnimation(shakeButtonAnimation);
                button_pill_parac_300.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        button_pill_parac_250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosagePillAmount.setText(getDosageAmount(amountOfParacetamolMax, 250));

                buttonParacetamolDosagePillAmount.setAnimation(shakeButtonAnimation);
                button_pill_parac_250.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);
            }
        });
    }


    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return "        " + String.valueOf(round(100.0 * amountOfParacetamol / dosageinMl) / 100.0) + " tabletki";
    }
}
