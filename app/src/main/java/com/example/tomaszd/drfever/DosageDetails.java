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
        Intent myIntent = getIntent();
        String paracetamolAmountValue = myIntent.getStringExtra("paracetamolAmount");
        dosageEditText.setText("Get : " + paracetamolAmountValue);
    }
}
