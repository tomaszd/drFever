package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectDrugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_drug);

        Button buttonParacetamol = (Button) findViewById(R.id.buttonParacetamol);
        buttonParacetamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SelectDrugActivity.this, "Paracetamol",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(SelectDrugActivity.this, ParacetamolActivity.class);
                SelectDrugActivity.this.startActivity(myIntent);
            }
        });

        Button buttonIbuprofen = (Button) findViewById(R.id.buttonIbupren);
        buttonIbuprofen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SelectDrugActivity.this, "Ibuprofen",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(SelectDrugActivity.this, IbuprenActivity.class);
                SelectDrugActivity.this.startActivity(myIntent);
            }
        });
    }
}
