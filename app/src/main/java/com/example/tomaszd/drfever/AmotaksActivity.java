package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AmotaksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amotaks_main);

        Button buttonParacetamol = (Button) findViewById(R.id.buttonParacetamol);
        buttonParacetamol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AmotaksActivity.this, "Let's Check Paracetamol",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(AmotaksActivity.this, ParacetamolActivity.class);
                AmotaksActivity.this.startActivity(myIntent);
            }
        });

        Button buttonAmotaks = (Button) findViewById(R.id.buttonAmotaks);
        buttonAmotaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AmotaksActivity.this, "Let's Count Amotaks",
                        Toast.LENGTH_LONG).show();
                //Intent myIntent = new Intent(AmotaksActivity.this, MainActivity.class);
                //AmotaksActivity.this.startActivity(myIntent);
            }
        });


    }
}
//@+id/buttonParacetamol