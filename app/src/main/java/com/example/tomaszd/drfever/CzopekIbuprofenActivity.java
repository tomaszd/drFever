package com.example.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import static java.lang.Math.round;

public class CzopekIbuprofenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_czopek_ibuprofen);


        final EditText editMaxIbuprofen = (EditText) findViewById(R.id.editMaxIbuprofen);
        final EditText editMinIbuprofen = (EditText) findViewById(R.id.editMinIbuprofen);

        Intent myIntent = getIntent();
        final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);

        editMinIbuprofen.setText(String.valueOf(amountOfIbuprofenMin));
        editMaxIbuprofen.setText(String.valueOf(amountOfIbuprofenMax));

        final EditText min60 = (EditText) findViewById(R.id.editMinCzopek60);
        final EditText min125 = (EditText) findViewById(R.id.editMinCzopek125);

        final EditText max60 = (EditText) findViewById(R.id.editMaxCzopek60);
        final EditText max125 = (EditText) findViewById(R.id.editMaxCzopek125);


        min60.setText(String.valueOf(round(100.0 * amountOfIbuprofenMin / 60.0) / 100.0));
        max60.setText(String.valueOf(round(100.0 * amountOfIbuprofenMax / 60.0) / 100.0));

        min125.setText(String.valueOf(round(100.0 * amountOfIbuprofenMin / 125.0) / 100.0));
        max125.setText(String.valueOf(round(100.0 * amountOfIbuprofenMax / 125.0) / 100.0));


    }

}
