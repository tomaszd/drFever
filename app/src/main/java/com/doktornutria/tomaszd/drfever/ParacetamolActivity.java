package com.doktornutria.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ParacetamolActivity extends AppCompatActivity {
    private int actualAge = 0;
    private int actualWeight = 0;
    private String amountOfDrugs = "";
    private double amountOfParacetamolMin;
    private double amountOfParacetamolMax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paracetamol);


        final SeekBar seekBarAge = (SeekBar) findViewById(R.id.seekBarAge);
        final TextView seekBarValue = (TextView) findViewById(R.id.textViewAgeParacetamol);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        final Button buttonCountParacetamol = (Button) findViewById(R.id.buttonCount);


        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                actualAge = progress;
                seekBarValue.setText(String.valueOf(actualAge) + " lat");
                buttonCountParacetamol.setAnimation(shakeButtonAnimation);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        final SeekBar seekBarWeight = (SeekBar) findViewById(R.id.seekBarWeight);
        final TextView seekBarWeightValue = (TextView) findViewById(R.id.textViewWeightParacetamol);

        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                buttonCountParacetamol.setAnimation(shakeButtonAnimation);
                actualWeight = progress;
                seekBarWeightValue.setText(String.valueOf(actualWeight + " kg"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });


        /**
         * Dawkowanie:

         Doustnie. Dorośli: 1-2 tabletki 2-4 razy na dobę, nie częściej niż co 4 godziny
         (maksymalna dawka dobowa w leczeniu doraźnym wynosi 4 g, w leczeniu długotrwałym 2,6 g).
         Dzieci: dawkę leku ustala się w zależności od wieku i masy ciała dziecka, zazwyczaj
         10-15 mg/kg masy ciała. Dzieci 7-12 rok życia: 1/2 tabletki co 6-8 godzin.
         Należy zasięgnąć opinii lekarza jeśli ból utrzymuje się dłużej niż 10 dni,
         a gorączka dłużej niż 3 dni.   W czasie stosowania leku nie należy pić alkoholu.
         Zapoznaj się z właściwościami leku opisanymi w ulotce przed jego zastosowaniem.
         Przed zastosowaniem leku należy sprawdzić datę ważności podaną na opakowaniu (etykiecie).
         Nie należy stosować leku po terminie ważności. Przechowuj lek w szczelnie zamkniętym
         opakowaniu, w miejscu niedostępnym i niewidocznym dla dzieci, zgodnie z wymogami producenta.
         */

        buttonCountParacetamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonCountParacetamol.setAnimation(shakeButtonAnimation);
                String amountParacetamol7_12 = getResources().getString(R.string.amountParacetamol7_12);
                String amountParacetamolAdult = getResources().getString(R.string.amountParacetamolAdult);
                if (actualWeight == 0) {
                    Toast.makeText(ParacetamolActivity.this, R.string.value_greater_than_0,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                if (actualAge < 7) {
                    amountOfParacetamolMin = actualWeight * 10;
                    amountOfParacetamolMax = actualWeight * 15;
                    amountOfDrugs = "Usually 10-15 mg/kg of weight.\nWhich means "
                            + String.valueOf(amountOfParacetamolMin) + "-"
                            + String.valueOf(amountOfParacetamolMax) + " for weight = "
                            + String.valueOf(actualWeight) + "kg.";

                } else if (actualAge >= 7 && actualAge <= 12) {
                    //1/2 pills every 6-8 hour
                    amountOfParacetamolMin = 0.5 * 500 * 3;// ( 0.5 pill every 8 hours = 0.5 pill 3 times a day )
                    amountOfParacetamolMax = 0.5 * 500 * 4;// ( 0.5 pill every 6 hours = 0.5 pill 4 times a day )
                    amountOfDrugs = amountParacetamol7_12;

                } else if (actualAge > 12) {
                    //1-2 pills 2-4 times a day , not often than 4 hours
                    amountOfParacetamolMin = 1 * 500 * 2;// ( 1 pill 2 times a day = )
                    amountOfParacetamolMax = 2 * 500 * 4;// (2 pills 4 times a day )
                    amountOfDrugs = amountParacetamolAdult;
                }


                //TODO wiser algorithm

                amountOfParacetamolMax = actualWeight * 15;


                //textCounted.setText(amountOfDrugs);
                //view.startAnimation(shakeButtonAnimation);
                Intent myIntent = new Intent(ParacetamolActivity.this, DosageDetails.class);
                myIntent.putExtra("paracetamolAmount", amountOfDrugs);
                myIntent.putExtra("amountOfParacetamolMin", amountOfParacetamolMin);
                myIntent.putExtra("amountOfParacetamolMax", amountOfParacetamolMax);
                startActivity(myIntent);

            }
        });

    }
}
