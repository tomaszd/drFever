package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DosageDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosage_details);
        final EditText dosageEditText = (EditText) findViewById(R.id.textDosageDetails);
        final EditText editMaxParacetamol = (EditText) findViewById(R.id.editMaxParacetamol);
        final EditText editMinParacetamol = (EditText) findViewById(R.id.editMinParacetamol);
        Intent myIntent = getIntent();
        String paracetamolAmountValue = myIntent.getStringExtra("paracetamolAmount");
        Double amountOfParacetamolMinValue = myIntent.getDoubleExtra("amountOfParacetamolMin",0.0);
        Double amountOfParacetamolMaxValue = myIntent.getDoubleExtra("amountOfParacetamolMax",0.0);

        dosageEditText.setText("Get : " + paracetamolAmountValue);
        editMaxParacetamol.setText(String.valueOf(amountOfParacetamolMaxValue));
        editMinParacetamol.setText(String.valueOf(amountOfParacetamolMinValue));




    }
}
