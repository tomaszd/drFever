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


        Button button = (Button) findViewById(R.id.buttonCheckParacetamol);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AmotaksActivity.this, "Lets check Paracetamol",
                        Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(AmotaksActivity.this, MainActivity.class);
                AmotaksActivity.this.startActivity(myIntent);
            }
        });
    }
}
