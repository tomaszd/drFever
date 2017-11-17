package com.example.tomaszd.drfever;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        Button buttonSaveUserData = (Button) findViewById(R.id.buttonSaveUserData);
        buttonSaveUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddNewUserActivity.this, "Data for user Saved",
                        Toast.LENGTH_LONG).show();
                //TODO Save Data!!!!
            }
        });

        Button buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddNewUserActivity.this, "Cancel add user",
                        Toast.LENGTH_LONG).show();
                onBackPressed();
            }
        });
        SeekBar seekBarAge = (SeekBar) findViewById(R.id.seekBarAge);
        final TextView textSelectAge = (TextView) findViewById(R.id.textSelectAge);
        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                int actualAge = (progress* 10) / 10 ;
                textSelectAge.setText(String.valueOf(actualAge + " years"));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });


        SeekBar seekBarWeight = (SeekBar) findViewById(R.id.seekBarWeight);
        final TextView textSelectWeight = (TextView) findViewById(R.id.textSelectWeight);
        seekBarWeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                int actualWeight = (progress * 10) / 10 ;
                textSelectWeight.setText(String.valueOf(actualWeight + " kg"));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });


    }


}
