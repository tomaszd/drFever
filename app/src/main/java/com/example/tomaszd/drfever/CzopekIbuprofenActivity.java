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

public class CzopekIbuprofenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_czopek_ibuprofen);
        //Dostępne czopki z ibuprofenem: 60 mg, 125 mg

        final Button buttonIbuprofenDosageAmount = (Button) findViewById(R.id.buttonIbuprofenDosageAmount);
        final Button buttonIbuprofenDosageCzopekAmount = (Button) findViewById(R.id.buttonIbuprofenDosageCzopekAmount);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Intent myIntent = getIntent();
        //final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);

        buttonIbuprofenDosageAmount.setText(String.valueOf("        " + String.valueOf(amountOfIbuprofenMax) + " mg"));
        buttonIbuprofenDosageCzopekAmount.setText("Wybierz czopek");

        final Button buttonCzopekIbuprofen60 = (Button) findViewById(R.id.buttonCzopekIbuprofen60);
        final Button buttonCzopekIbuprofenCzopek125 = (Button) findViewById(R.id.buttonCzopekIbuprofenCzopek125);

        buttonCzopekIbuprofen60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIbuprofenDosageCzopekAmount.setText(getDosageAmount(amountOfIbuprofenMax, 60));

                buttonIbuprofenDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                buttonCzopekIbuprofen60.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);

            }
        });

        buttonCzopekIbuprofenCzopek125.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonIbuprofenDosageCzopekAmount.setText(getDosageAmount(amountOfIbuprofenMax, 125));

                buttonCzopekIbuprofenCzopek125.setAnimation(shakeButtonAnimation);
                buttonIbuprofenDosageCzopekAmount.setAnimation(shakeButtonAnimation);
                view.startAnimation(shakeButtonAnimation);
            }
        });
    }

    @NonNull
    private String getDosageAmount(Double amountOfIbuprofen, int dosageinMl) {
        return "          " + String.valueOf(round((100.0 * amountOfIbuprofen / dosageinMl) / 100.0) * 100.0) + " % dawki";
    }
}
