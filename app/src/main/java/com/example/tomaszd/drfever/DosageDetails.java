package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DosageDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosage_details);
        //final EditText dosageEditText = (EditText) findViewById(R.id.textDosageDetails);
        final EditText editMaxParacetamol = (EditText) findViewById(R.id.editMaxParacetamol);
        final EditText editMinParacetamol = (EditText) findViewById(R.id.editMinParacetamol);
        Intent myIntent = getIntent();
        String dawkownaieValue = myIntent.getStringExtra("paracetamolAmount");
        Double amountOfParacetamolMinValue = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        Double amountOfParacetamolMaxValue = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);
        //dosageEditText.setText("Get : " + paracetamolAmountValue);
        editMaxParacetamol.setText(String.valueOf(amountOfParacetamolMaxValue));
        editMinParacetamol.setText(String.valueOf(amountOfParacetamolMinValue));
        //Pills
        Button buttonPill = (Button) findViewById(R.id.buttonPill);
        buttonPill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DosageDetails.this, "Pills",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(DosageDetails.this, PillDosageActivity.class);
                DosageDetails.this.startActivity(myIntent);
            }
        });

        //syrop
        Button buttonSyrop = (Button) findViewById(R.id.buttonSirop);
        buttonSyrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DosageDetails.this, "Sirop",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(DosageDetails.this, SirupDosageActivity.class);
                DosageDetails.this.startActivity(myIntent);
            }
        });
        //czopki
        Button buttonCzopek = (Button) findViewById(R.id.buttonCzopek);
        buttonCzopek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DosageDetails.this, "Czopek",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(DosageDetails.this, CzopekActivity.class);
                DosageDetails.this.startActivity(myIntent);
            }
        });


    }
}
