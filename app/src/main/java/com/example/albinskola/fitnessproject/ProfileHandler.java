package com.example.albinskola.fitnessproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileHandler extends AppCompatActivity {

    private Button submitButton;
    private EditText weightField;
    private EditText heightField;
    private EditText sexField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_handler);

        submitButton = (Button) findViewById(R.id.SubmitButton);
        weightField = (EditText) findViewById(R.id.WeightField);
        heightField = (EditText) findViewById(R.id.HeightField);
        sexField = (EditText) findViewById(R.id.SexField);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
