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

public class SirupDosageActivity extends AppCompatActivity {

    private double amountOfParacetamolMax1 = 1.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sirup_dosage);
        //W przypadku Paracetamolu na rynku dostępne są tabletki 200 mg i 400 mg (forte, max, itp.)

        final Button buttonParacetamolDosageAmount = (Button) findViewById(R.id.buttonParacetamolDosageAmount);
        final Button buttonParacetamolDosageSirupAmount = (Button) findViewById(R.id.buttonParacetamolDosageSirupAmount);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Intent myIntent = getIntent();
        //final Double amountOfParacetamolMin = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        final Double amountOfParacetamolMax = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);

        buttonParacetamolDosageAmount.setText(String.valueOf("        " + String.valueOf(amountOfParacetamolMax) + " mg"));
        buttonParacetamolDosageSirupAmount.setText("Syrop");

        final Button buttonsirup_parac_500_5 = (Button) findViewById(R.id.buttonsirup_parac_500_5);
        final Button buttonsirup_parac_250_5 = (Button) findViewById(R.id.buttonsirup_parac_250_5);
        final Button buttonsirup_parac_200_5 = (Button) findViewById(R.id.buttonsirup_parac_200_5);
        final Button buttonsirup_parac_120_5 = (Button) findViewById(R.id.buttonsirup_parac_120_5);


        buttonsirup_parac_500_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageSirupAmount.setText(getDosageAmount(amountOfParacetamolMax, 500));

                buttonParacetamolDosageSirupAmount.setAnimation(shakeButtonAnimation);
                buttonsirup_parac_500_5.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        buttonsirup_parac_250_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageSirupAmount.setText(getDosageAmount(amountOfParacetamolMax, 250));

                buttonParacetamolDosageSirupAmount.setAnimation(shakeButtonAnimation);
                buttonsirup_parac_250_5.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });


        buttonsirup_parac_200_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageSirupAmount.setText(getDosageAmount(amountOfParacetamolMax, 200));

                buttonParacetamolDosageSirupAmount.setAnimation(shakeButtonAnimation);
                buttonsirup_parac_200_5.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        buttonsirup_parac_120_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonParacetamolDosageSirupAmount.setText(getDosageAmount(amountOfParacetamolMax, 120));

                buttonParacetamolDosageSirupAmount.setAnimation(shakeButtonAnimation);
                buttonsirup_parac_120_5.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(SirupDosageActivity.this, DosageDetails.class);
        myIntent.putExtra("amountOfParacetamolMax", amountOfParacetamolMax1);
        startActivity(myIntent);
    }

    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return "        " + String.valueOf(round(100.0 * amountOfParacetamol * 5 / dosageinMl) / 100.0) + " ml";
    }
}
