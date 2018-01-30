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

public class SirupDosageIbuprofenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sirup_dosage_ibuprofen);
        //W przypadku ibuprofenu na rynku dostępne są tabletki 200 mg i 400 mg (forte, max, itp.)

        final Button buttonIbuprofenDosageAmount = (Button) findViewById(R.id.buttonIbuprofenDosageAmount);
        final Button buttonIbuprofenDosageSirupAmount = (Button) findViewById(R.id.buttonIbuprofenDosageSirupAmount);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Intent myIntent = getIntent();
        //final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);

        buttonIbuprofenDosageAmount.setText(String.valueOf("        " + String.valueOf(amountOfIbuprofenMax) + " mg"));
        buttonIbuprofenDosageSirupAmount.setText("          Wybierz syrop");

        final Button buttonsirup_ibuprof_100_5 = (Button) findViewById(R.id.buttonsirup_ibuprof_100_5);
        final Button buttonsirup_ibuprof_200_5 = (Button) findViewById(R.id.buttonsirup_ibuprof_200_5);


        buttonsirup_ibuprof_100_5.setAnimation(shakeButtonAnimation);
        buttonsirup_ibuprof_200_5.setAnimation(shakeButtonAnimation);

        buttonsirup_ibuprof_100_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIbuprofenDosageSirupAmount.setText(getDosageAmount(amountOfIbuprofenMax, 100));

                buttonIbuprofenDosageSirupAmount.setAnimation(shakeButtonAnimation);
                buttonsirup_ibuprof_100_5.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        buttonsirup_ibuprof_200_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIbuprofenDosageSirupAmount.setText(getDosageAmount(amountOfIbuprofenMax, 200));

                buttonsirup_ibuprof_200_5.setAnimation(shakeButtonAnimation);
                buttonIbuprofenDosageSirupAmount.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);
            }
        });
    }

    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return "  " + String.valueOf(round(100.0 * amountOfParacetamol * 5 / dosageinMl) / 100.0) + " ml";
    }
}
