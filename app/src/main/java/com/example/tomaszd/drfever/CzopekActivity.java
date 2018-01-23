package com.example.tomaszd.drfever;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CzopekActivity extends AppCompatActivity {
    /**
     *  50 mg, 80 mg, 125 mg, 150 mg, 180 mg, 250 mg, 300 mg
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_czopek);

        Intent myIntent = getIntent();
        final Double amountOfIbuprofenMin = myIntent.getDoubleExtra("amountOfParacetamolMin", 0.0);
        final Double amountOfIbuprofenMax = myIntent.getDoubleExtra("amountOfParacetamolMax", 0.0);
    }
}
