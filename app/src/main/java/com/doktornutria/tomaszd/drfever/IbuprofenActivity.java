package com.doktornutria.tomaszd.drfever;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.min;

public class IbuprofenActivity extends AppCompatActivity {
    private int actualAge = 0;
    private int actualWeight = 0;
    private String amountOfDrugs = "";
    private double amountOfIbuprofenMin;
    private double amountOfIbuprofenMax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibuprofen);

        final SeekBar seekBarAge = (SeekBar) findViewById(R.id.seekBarAgeIbuprofen);
        final TextView seekBarValue = (TextView) findViewById(R.id.textViewAgeIbupremValue);
        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        final Button buttonCountIbuprem = (Button) findViewById(R.id.buttonCountIbuprofen);
        final SeekBar seekBarWeight = (SeekBar) findViewById(R.id.seekBarWeightIbuprofen);
        final TextView seekBarWeightValue = (TextView) findViewById(R.id.textViewWeightInKgIbuprofenValue);


        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        actualAge = sharedPref.getInt("ibuprofenAge", 8);
        actualWeight = sharedPref.getInt("ibuprofenWeight", 20);
        seekBarAge.setProgress(actualAge);
        seekBarWeight.setProgress(actualWeight);
        seekBarValue.setText(String.valueOf(actualAge) + " lat");
        seekBarWeightValue.setText(String.valueOf(actualWeight + " kg"));


        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                actualAge = progress;
                seekBarValue.setText(String.valueOf(actualAge) + " lat");
                buttonCountIbuprem.setAnimation(shakeButtonAnimation);
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


        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                actualWeight = progress;
                seekBarWeightValue.setText(String.valueOf(actualWeight + " kg"));
                buttonCountIbuprem.setAnimation(shakeButtonAnimation);
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

         Indywidualnie w zależności od stopnia ciężkości choroby i tolerancji na lek. Podane dawki
         odnoszą się do ibuprofenu w postaci racematu, w razie stosowania deksibuprofenu powinny być 
         zmniejszone o 25% (100 mg mieszaniny racemicznej odpowiada 75 mg deksibuprofenu). Dorośli. 
         W chorobach reumatycznych 200–800 mg 3 ×/d. Przeciwbólowo 200–400 mg 4–6 ×/d. W bolesnych 
         miesiączkach 400 mg 4 ×/d. Maks. dawka dobowa 3,2 g, jednak zwykle nie zaleca się stosowania
         dawek >1,2 g/d. Dzieci. 3. mż.–12. rż. przeciwgorączkowo i przeciwbólowo maks. 
         20–30 mg/kg mc./d w 3–4 daw. podz.; w młodzieńczym przewlekłym RZS 2.–15. rż. 20–40 mg/kg mc./d w 3–4 daw.
         podz. Miejscowo u osób po 12. rż.: 4–10 cm kremu lub żelu nałożyć i wcierać w chorobowo 
         zmienione miejsca; w przypadku dużych krwiaków i skręceń można stosować pod opatrunkiem okluzyjnym.
         */

        buttonCountIbuprem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                buttonCountIbuprem.setAnimation(shakeButtonAnimation);
                if (actualWeight == 0) {
                    Toast.makeText(IbuprofenActivity.this, R.string.value_greater_than_0,
                            Toast.LENGTH_LONG).show();
                    return;
                }
                //Dzieci. 3. mż.–12. rż. przeciwgorączkowo i przeciwbólowo maks.
                //20–30 mg/kg mc./d w 3–4 daw. podz.;
                if (actualAge < 13) {
                    amountOfIbuprofenMin = actualWeight * 20;
                    amountOfIbuprofenMax = actualWeight * 30;
                    amountOfDrugs = "*W 3-4 dawkach co 6-8 godzin";
                    //Przeciwbólowo 200–400 mg 4–6 ×/d. W bolesnych
                    // miesiączkach 400 mg 4 ×/d.
                } else if (actualAge > 12) {
                    //1-2 pills 2-4 times a day , not often than 4 hours
                    amountOfIbuprofenMin = 200 * 4; // (Przeciwbólowo 200–400 mg 4–6 ×/d. W bolesnych  =200 *4
                    amountOfIbuprofenMax = 400 * 6; // (Przeciwbólowo 200–400 mg 4–6 ×/d. W bolesnych  =400 *6
                    amountOfDrugs = "*W 4-6 dawkach co 4-6 godzin";
                }


                //TODO wiser algorithm

                int maxDawkaIbuprofen = 400;
                if (actualAge < 10 || actualWeight < 30) {
                    maxDawkaIbuprofen = 200;
                }

                if ((10 <= actualAge && actualAge <= 12) || (30 <= actualWeight && actualWeight <= 39)) {
                    maxDawkaIbuprofen = 270;
                }
                if (actualAge > 12 || actualWeight > 39) {
                    maxDawkaIbuprofen = 400;
                }
                //10mg/kg
                amountOfIbuprofenMax = min(actualWeight * 10, maxDawkaIbuprofen);


                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("ibuprofenAge", actualAge);
                editor.commit();
                editor.putInt("ibuprofenWeight", actualWeight);
                editor.commit();

                //view.startAnimation(shakeButtonAnimation);
                Intent myIntent = new Intent(IbuprofenActivity.this, DosageDetailsIbuprofen.class);
                myIntent.putExtra("ibuprofenDetails", amountOfDrugs);
                myIntent.putExtra("amountOfIbuprofenMin", amountOfIbuprofenMin);
                myIntent.putExtra("amountOfIbuprofenMax", amountOfIbuprofenMax);
                startActivity(myIntent);

            }
        });

    }
}
