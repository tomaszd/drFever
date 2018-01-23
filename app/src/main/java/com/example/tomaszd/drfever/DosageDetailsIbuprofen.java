package com.example.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DosageDetailsIbuprofen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosage_details_ibuprofen);
        final EditText editMaxIbuprofen = (EditText) findViewById(R.id.editMaxIbuprofen);
        final EditText editMinIbuprofen = (EditText) findViewById(R.id.editMinIbuprofen);
        final TextView txtIbuprofenDetails = (TextView) findViewById(R.id.txtIbuprofenDetails);
        Intent myIntent = getIntent();
        final String ibuprofenDetails = myIntent.getStringExtra("ibuprofenDetails");
        final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);
        editMaxIbuprofen.setText(String.valueOf(amountOfIbuprofenMax));
        editMinIbuprofen.setText(String.valueOf(amountOfIbuprofenMin));
        txtIbuprofenDetails.setText(ibuprofenDetails);
        //Pills
        Button buttonPill = (Button) findViewById(R.id.buttonPillIbuprofen);
        buttonPill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DosageDetailsIbuprofen.this, PillDosageIbuprofenActivity.class);
                startNewDetailedActivityWithData(myIntent, ibuprofenDetails, amountOfIbuprofenMin, amountOfIbuprofenMax);
            }
        });

        //syrop
        Button buttonSyrop = (Button) findViewById(R.id.buttonSiropIbuprofen);
        buttonSyrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DosageDetailsIbuprofen.this, SirupDosageIbuprofenActivity.class);
                startNewDetailedActivityWithData(myIntent, ibuprofenDetails, amountOfIbuprofenMin, amountOfIbuprofenMax);
            }
        });
        //czopki
        Button buttonCzopek = (Button) findViewById(R.id.buttonCzopekIbuprofen);
        buttonCzopek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(DosageDetailsIbuprofen.this, CzopekIbuprofenActivity.class);
                startNewDetailedActivityWithData(myIntent, ibuprofenDetails, amountOfIbuprofenMin, amountOfIbuprofenMax);
            }
        });
    }

    private void startNewDetailedActivityWithData(Intent myIntent, String ibuprofenDetails, Double amountOfIbuprofenMin, Double amountOfIbuprofenMax) {
        myIntent.putExtra("ibuprofenDetails", ibuprofenDetails);
        myIntent.putExtra("amountOfIbuprofenMin", amountOfIbuprofenMin);
        myIntent.putExtra("amountOfIbuprofenMax", amountOfIbuprofenMax);
        DosageDetailsIbuprofen.this.startActivity(myIntent);
    }
}
