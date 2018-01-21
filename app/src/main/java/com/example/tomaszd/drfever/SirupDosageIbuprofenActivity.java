package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import static java.lang.Math.round;

public class SirupDosageIbuprofenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sirup_dosage_ibuprofen);


        //Ibuprofen występuje w 2 stężeniach – 100 mg/5ml lub 200 mg/5ml (forte). Zatem dziecku podasz 6 ml zwykłego syropu lub 3 ml preparatu forte.


        final EditText editMinIbuprofenSirup = (EditText) findViewById(R.id.editMinIbuprofenSirup);
        final EditText editMaxIbuprofenSirup = (EditText) findViewById(R.id.editMaxIbuprofenSirup);

        Intent myIntent = getIntent();
        final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);

        editMinIbuprofenSirup.setText(String.valueOf(amountOfIbuprofenMin));
        editMaxIbuprofenSirup.setText(String.valueOf(amountOfIbuprofenMax));

        final EditText min100 = (EditText) findViewById(R.id.editMin100);
        final EditText min200 = (EditText) findViewById(R.id.editMin200);

        final EditText max100 = (EditText) findViewById(R.id.editMax100);
        final EditText max200 = (EditText) findViewById(R.id.editMax200);


        min100.setText(String.valueOf(round(100.0 * amountOfIbuprofenMin * 5 / 100.0) / 100.0));
        min200.setText(String.valueOf(round(100.0 * amountOfIbuprofenMin * 5 / 200.0) / 100.0));

        max100.setText(String.valueOf(round(100.0 * amountOfIbuprofenMax * 5 / 100.0) / 100.0));
        max200.setText(String.valueOf(round(100.0 * amountOfIbuprofenMax * 5 / 200.0) / 100.0));


    }
}
