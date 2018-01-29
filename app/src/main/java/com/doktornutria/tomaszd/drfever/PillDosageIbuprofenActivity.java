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

public class PillDosageIbuprofenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_dosage_ibuprofen);
        //W przypadku ibuprofenu na rynku dostępne są tabletki 200 mg i 400 mg (forte, max, itp.)

        final Button buttonIbuprofenDosageAmount = (Button) findViewById(R.id.buttonIbuprofenDosageAmount);
        final Button buttonIbuprofenDosagePillAmount = (Button) findViewById(R.id.buttonIbuprofenDosagePillAmount);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Intent myIntent = getIntent();
        //final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);

        buttonIbuprofenDosageAmount.setText(String.valueOf("        " + String.valueOf(amountOfIbuprofenMax) + " mg"));
        buttonIbuprofenDosagePillAmount.setText("Wcisnij dawke tabletki");

        final Button buttonPillIbuprofen200Forte = (Button) findViewById(R.id.buttonPillIbuprofen200Forte);
        final Button buttonPillIbuprofen400Max = (Button) findViewById(R.id.buttonPillIbuprofen400Max);
        buttonPillIbuprofen200Forte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIbuprofenDosagePillAmount.setText(getDosageAmount(amountOfIbuprofenMax, 200));

                buttonIbuprofenDosagePillAmount.setAnimation(shakeButtonAnimation);
                buttonPillIbuprofen200Forte.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        buttonPillIbuprofen400Max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIbuprofenDosagePillAmount.setText(getDosageAmount(amountOfIbuprofenMax, 400));

                buttonPillIbuprofen400Max.setAnimation(shakeButtonAnimation);
                buttonIbuprofenDosagePillAmount.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);
            }
        });
    }

    @NonNull
    private String getDosageAmount(Double amountOfParacetamol, int dosageinMl) {
        return String.valueOf(round(100.0 * amountOfParacetamol / dosageinMl) / 100.0);
    }

}
