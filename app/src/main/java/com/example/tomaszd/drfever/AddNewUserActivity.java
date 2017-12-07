package com.example.tomaszd.drfever;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewUserActivity extends AppCompatActivity {
    int actualWeight = 0;
    int actualAge = 0;
    String actualName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText actualName = (EditText) findViewById(R.id.editEnterName);
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
                actualAge = (progress * 10) / 10;
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
                actualWeight = (progress * 10) / 10;
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


        Button buttonSaveUserData = (Button) findViewById(R.id.buttonSaveUserData);
        buttonSaveUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String actualNameValue = ;
                saveUserData(actualName.getText().toString(), actualAge, actualWeight);
                onBackPressed();
            }
        });

    }

    /**
     * Function to save user data to the sharedPreferences
     */
    private void saveUserData(String name, int age, int weight) {

        if (name.equals("") || age == 0 || weight == 0) {
            Toast.makeText(AddNewUserActivity.this,
                    "Please add proper name, age, weight",
                    Toast.LENGTH_LONG).show();
            return;
        }

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name);
        editor.putInt("age", age);
        editor.putInt("weight", weight);
        editor.apply();

        Toast.makeText(AddNewUserActivity.this,
                "Data for user Saved: \n"
                        + "Name: " + name + "\n"
                        + "Age: " + String.valueOf(age) + "\n"
                        + "Weight: " + String.valueOf(weight),

                Toast.LENGTH_LONG).show();
    }

}
