package com.doktornutria.tomaszd.drfever;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class SelectDrugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_drug);

        final Animation shakeButtonAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        Button buttonIbuprofen = (Button) findViewById(R.id.buttonIbuprofen);
        buttonIbuprofen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SelectDrugActivity.this, "Ibuprofen",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(SelectDrugActivity.this, IbuprofenActivity.class);
                SelectDrugActivity.this.startActivity(myIntent);
            }
        });

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
        buttonIbuprofen.setAnimation(shakeButtonAnimation);
        buttonParacetamol.setAnimation(shakeButtonAnimation);

    }
}
