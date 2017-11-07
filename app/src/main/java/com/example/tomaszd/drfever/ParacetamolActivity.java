package com.example.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ParacetamolActivity extends AppCompatActivity {
    private int actualAge = 0;
    private int actualWeight = 0;
    private String amountOfDrugs = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paracetamol);

        final EditText textCounted = (EditText) findViewById(R.id.editTextCounted);


        SeekBar seekBarAge = (SeekBar) findViewById(R.id.seekBarAge);
        final TextView seekBarValue = (TextView) findViewById(R.id.textViewAgeParacetamol);

        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                actualAge = (progress * 10) / 100;
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

        SeekBar seekBarWeight = (SeekBar) findViewById(R.id.seekBarWeight);
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


        Button button = (Button) findViewById(R.id.buttonCount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ParacetamolActivity.this, "Counting of drug amount in Progress...",
                        Toast.LENGTH_LONG).show();
                amountOfDrugs = "Please give to the kid: " + String.valueOf((actualAge * actualWeight) / 10);
                textCounted.setText(amountOfDrugs);
            }
        });

        Button buttonCheckAmotaks = (Button) findViewById(R.id.buttonCheckAmotaks);
        buttonCheckAmotaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ParacetamolActivity.this, "Check Amotaks",
                        Toast.LENGTH_LONG).show();

                Intent myIntent = new Intent(ParacetamolActivity.this, AmotaksActivity.class);
                ParacetamolActivity.this.startActivity(myIntent);
            }


        });


    }
}
