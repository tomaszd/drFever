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
        final TextView txtibuprofenDetails = (TextView) findViewById(R.id.txtIbuprofenDetails);
        Intent myIntent = getIntent();
        String dosageIbuprofenDetails = myIntent.getStringExtra("ibuprofenDetails");
        Double amountOfIbuprofenMinValue = myIntent.getDoubleExtra("amountOfIbuprofenMin", 0.0);
        Double amountOfIbuprofenMaxValue = myIntent.getDoubleExtra("amountOfIbuprofenMax", 0.0);
        editMaxIbuprofen.setText(String.valueOf(amountOfIbuprofenMaxValue));
        editMinIbuprofen.setText(String.valueOf(amountOfIbuprofenMinValue));
        txtibuprofenDetails.setText(dosageIbuprofenDetails);
        //Pills
        Button buttonPill = (Button) findViewById(R.id.buttonPillIbuprofen);
        buttonPill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DosageDetailsIbuprofen.this, "Pills",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(DosageDetailsIbuprofen.this, PillDosageIbuprofenActivity.class);
                DosageDetailsIbuprofen.this.startActivity(myIntent);
            }
        });

        //syrop
        Button buttonSyrop = (Button) findViewById(R.id.buttonSiropIbuprofen);
        buttonSyrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DosageDetailsIbuprofen.this, "Sirop",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(DosageDetailsIbuprofen.this, SirupDosageIbuprofenActivity.class);
                DosageDetailsIbuprofen.this.startActivity(myIntent);
            }
        });
        //czopki
        Button buttonCzopek = (Button) findViewById(R.id.buttonCzopekIbuprofen);
        buttonCzopek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DosageDetailsIbuprofen.this, "Czopek",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(DosageDetailsIbuprofen.this, CzopekIbuprofenActivity.class);
                DosageDetailsIbuprofen.this.startActivity(myIntent);
            }
        });
    }
}
