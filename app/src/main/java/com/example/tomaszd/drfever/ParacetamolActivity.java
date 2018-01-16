package com.example.tomaszd.drfever;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.StringDef;
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

        final TextView textCounted = (TextView) findViewById(R.id.editTextCounted);
        final SeekBar seekBarAge = (SeekBar) findViewById(R.id.seekBarAge);
        final TextView seekBarValue = (TextView) findViewById(R.id.textViewAgeParacetamol);
        final Button buttonLoadData = (Button) findViewById(R.id.loadUser);
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        final Button buttonCountParacetamol = (Button) findViewById(R.id.buttonCount);
        final Button buttonSeeDosageDetails = (Button) findViewById(R.id.seeDosageDetails);

        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                actualAge = (progress * 20) / 100;
                seekBarValue.setText(String.valueOf(actualAge) + " years");
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
                actualWeight = (progress * 10) / 50;
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
                Toast.makeText(ParacetamolActivity.this, "Counting of drug amount in Progress...",
                        Toast.LENGTH_LONG).show();
                if (actualWeight == 0 || actualAge == 0) {
                    textCounted.setText(R.string.select_age_and_weight);
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

                textCounted.setText(amountOfDrugs);
                view.startAnimation(shakeButtonAnimation);
            }
        });

        Button buttonCheckAmotaks = (Button) findViewById(R.id.buttonSelectDrug);
        buttonCheckAmotaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ParacetamolActivity.this, "Check Amotaks",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(ParacetamolActivity.this, SelectDrugActivity.class);
                ParacetamolActivity.this.startActivity(myIntent);
            }


        });

        Button buttonAddNewUser = (Button) findViewById(R.id.addNewUser);
        buttonAddNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ParacetamolActivity.this, "Please Add New User Data",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(ParacetamolActivity.this, AddNewUserActivity.class);
                ParacetamolActivity.this.startActivity(myIntent);
            }


        });

        buttonLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonLoadData.setAnimation(shakeButtonAnimation);
                String actualName = preferences.getString("name", "");
                actualAge = preferences.getInt("age", 0);
                actualWeight = preferences.getInt("weight", 0);
                Toast.makeText(ParacetamolActivity.this, "User loaded: " + actualName + "\n"
                                + "Age: " + String.valueOf(actualAge) + "\n"
                                + "Name: " + String.valueOf(actualWeight),

                        Toast.LENGTH_LONG).show();
                seekBarWeightValue.setText(String.valueOf(actualWeight + " kg"));
                seekBarValue.setText(String.valueOf(actualAge) + " years");
                seekBarAge.setProgress(actualAge * 100 / 20);
                seekBarWeight.setProgress(actualWeight * 50 / 10);
                view.startAnimation(shakeButtonAnimation);
            }
        });
        buttonSeeDosageDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSeeDosageDetails.setAnimation(shakeButtonAnimation);
                Toast.makeText(ParacetamolActivity.this, "Check details",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(ParacetamolActivity.this, DosageDetails.class);
                myIntent.putExtra("paracetamolAmount", amountOfDrugs);
                myIntent.putExtra("amountOfParacetamolMin", amountOfParacetamolMin);
                myIntent.putExtra("amountOfParacetamolMax", amountOfParacetamolMax);
                startActivity(myIntent);
            }


        });

    }
}
