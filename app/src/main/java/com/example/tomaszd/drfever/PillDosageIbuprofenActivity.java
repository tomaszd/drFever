package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import static java.lang.Math.round;

public class PillDosageIbuprofenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_dosage_ibuprofen);
        //W przypadku ibuprofenu na rynku dostępne są tabletki 200 mg i 400 mg (forte, max, itp.)

        final EditText editMinIbuprofenPill = (EditText) findViewById(R.id.editMinIbuprofenPill);
        final EditText editMaxIbuprofenPill = (EditText) findViewById(R.id.editMaxIbuprofenPill);

        Intent myIntent = getIntent();
        final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);

        editMinIbuprofenPill.setText(String.valueOf(amountOfIbuprofenMin));
        editMaxIbuprofenPill.setText(String.valueOf(amountOfIbuprofenMax));

        final EditText min200 = (EditText) findViewById(R.id.editMin200);
        final EditText min400 = (EditText) findViewById(R.id.editMin400);

        final EditText max200 = (EditText) findViewById(R.id.editMax200);
        final EditText max400 = (EditText) findViewById(R.id.editMax400);


        min200.setText(String.valueOf(round(100.0 * amountOfIbuprofenMin / 200.0) / 100.0));
        min400.setText(String.valueOf(round(100.0 * amountOfIbuprofenMin / 400.0) / 100.0));

        max200.setText(String.valueOf(round(100.0 * amountOfIbuprofenMax / 200.0) / 100.0));
        max400.setText(String.valueOf(round(100.0 * amountOfIbuprofenMax / 400.0) / 100.0));
    }
}
